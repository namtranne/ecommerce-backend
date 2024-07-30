package com.ecommerce.server.controller;

import com.ecommerce.server.dto.RequestResponse;
import com.ecommerce.server.entity.ProductReview;
import com.ecommerce.server.entity.User;
import com.ecommerce.server.repository.ProductReviewRepository;
import com.ecommerce.server.security.CustomUserDetails;
import com.ecommerce.server.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ProductReviewRepository repository;

    @Autowired
    UserService userService;

    @GetMapping
    public List<ProductReview> getProductReview(@RequestParam(name="productId") Integer productId) {
        return repository.findAllByProductId(productId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProductReview(@RequestBody ProductReview review) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = "";
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails){
            username = userDetails.getUsername();
            User user = userService.getUserDetailByUsername(username);
            Optional <ProductReview> productReview = repository.findByProductIdAndUserId(review.getProductId(), user.getId());
            if(productReview.isPresent()) {
                RequestResponse response = new RequestResponse();
                response.setStatus("Fail");
                response.setMessage("You already reviewed this product!");
                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
            }
            else {
                review.setUserId(user.getId());
                review.setReviewerName(user.getFirstName() + " " + user.getLastName());
                repository.save(review);
                RequestResponse response = new RequestResponse();
                response.setStatus("Ok");
                response.setMessage("Reviewed submitted!!");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        }

        RequestResponse response = new RequestResponse();
        response.setStatus("Fail");
        response.setMessage("You need to login before submitting a review!");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
