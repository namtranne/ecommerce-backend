package com.ecommerce.server.controller;

import com.ecommerce.server.dto.CartDTO;
import com.ecommerce.server.dto.RequestResponse;
import com.ecommerce.server.entity.CartItem;
import com.ecommerce.server.entity.Products;
import com.ecommerce.server.repository.CartItemRepository;
import com.ecommerce.server.repository.ProductsRepository;
import com.ecommerce.server.security.CustomUserDetails;
import com.ecommerce.server.security.UserService;
import com.ecommerce.server.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/auth/cart")
public class CartController {

    @Autowired
    CartItemRepository repository;

    @Autowired
    ProductsService productsService;


    @Autowired
    UserService userService;

    @PostMapping(value="/add")
    public ResponseEntity<?> addCartItem(@RequestBody CartItem cartItem) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            Integer userId = userDetails.getUser().getId();
            try {
                Optional<CartItem> optionalCartItem = repository.findByProductIdAndConfigurableProductId(cartItem.getProductId(), cartItem.getConfigurableProductId());
                if(optionalCartItem.isPresent()) {
                    CartItem cartItem1 = optionalCartItem.get();
                    Integer newQuantity = optionalCartItem.get().getQuantity() + cartItem.getQuantity();
                    cartItem1.setQuantity(newQuantity);
                    repository.save(cartItem1);
                }
                else {
                    cartItem.setUserId(userId);
                    repository.save(cartItem);
                }
                RequestResponse response = new RequestResponse();
                response.setStatus("OK");
                response.setMessage("Item added to cart");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } catch(Exception e) {
                RequestResponse response = new RequestResponse();
                response.setStatus("Fail");
                response.setMessage("Can not add cart item");
                return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
            }
        }
        RequestResponse response = new RequestResponse();
        response.setStatus("Fail");
        response.setMessage("Can not authorize user");
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping
    public ResponseEntity<?> getCart() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            Integer userId = userDetails.getUser().getId();
            try {
                List<CartItem> cartItems = repository.findAllByUserId(userId);
                List<CartDTO> cartDTOS = new LinkedList<>();
                for(CartItem cartItem : cartItems) {
                    Products product = productsService.getProductCartById(cartItem.getProductId());
                    cartDTOS.add(new CartDTO(null, cartItem.getUserId(), product, cartItem.getConfigurableProductId(), cartItem.getOption1(), cartItem.getOption2(), cartItem.getImage(), cartItem.getQuantity()));
                }
                return new ResponseEntity<>(cartDTOS, HttpStatus.OK);
            } catch(Exception e) {
                RequestResponse response = new RequestResponse();
                response.setStatus("Fail");
                response.setMessage("Can not add cart item");
                return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
            }
        }
        RequestResponse response = new RequestResponse();
        response.setStatus("Fail");
        response.setMessage("Can not authorize user");
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }


}
