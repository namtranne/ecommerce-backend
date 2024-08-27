package com.ecommerce.server.controller;


import com.ecommerce.server.constant.HttpStatusCode;
import com.ecommerce.server.dto.WishListRequestDTO;
import com.ecommerce.server.dto.RequestResponse;
import com.ecommerce.server.dto.WishListResponseDTO;
import com.ecommerce.server.entity.Products;
import com.ecommerce.server.entity.WishList;
import com.ecommerce.server.security.CustomUserDetails;
import com.ecommerce.server.service.ProductsService;
import com.ecommerce.server.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class WishListController {

    @Autowired
    private WishListService service;

    @Autowired
    ProductsService productsService;

    @GetMapping("/auth/wishlist")
    public ResponseEntity<WishListResponseDTO> getUserWishList() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            try {
                Integer userId = userDetails.getUser().getId();
                List<Products> wishList = service.findByUserId(userId);
                WishListResponseDTO response = new WishListResponseDTO( HttpStatusCode.OK, wishList);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (Exception error) {
                WishListResponseDTO response = new WishListResponseDTO();
                response.setCode(HttpStatusCode.INTERNAL_SERVER_ERROR);
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        WishListResponseDTO response = new WishListResponseDTO();
        response.setCode(HttpStatusCode.UNAUTHORIZED);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/auth/wishlist")
    public ResponseEntity<RequestResponse> addWishList(@RequestBody WishListRequestDTO requestDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            try {
                Integer userId = userDetails.getUser().getId();
                WishList wishList = new WishList(null, userId, requestDTO.getProductId());
                service.save(wishList);
                RequestResponse response = new RequestResponse( "OK", "Add item to wishlist successfully");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (Exception error) {
                RequestResponse response = new RequestResponse("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        RequestResponse response = new RequestResponse("UNAUTHORIZED","UNAUTHORIZED");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/auth/wishlist")
    public ResponseEntity<RequestResponse> removeFromWishList(@RequestBody WishListRequestDTO requestDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            try {
                Integer userId = userDetails.getUser().getId();
                service.remove(requestDTO.getProductId(), userId);
                RequestResponse response = new RequestResponse( "OK", "Delete from wishlist successfully");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            catch (Exception error) {
                RequestResponse response = new RequestResponse("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        RequestResponse response = new RequestResponse("UNAUTHORIZED","UNAUTHORIZED");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

}
