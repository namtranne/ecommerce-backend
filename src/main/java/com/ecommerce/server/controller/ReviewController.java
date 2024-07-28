package com.ecommerce.server.controller;

import com.ecommerce.server.dto.RequestResponse;
import com.ecommerce.server.entity.ProductReview;
import com.ecommerce.server.repository.ProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    ProductReviewRepository repository;
    @GetMapping
    public List<ProductReview> getProductReview(@RequestParam(name="productId") Integer productId) {
        return repository.findAllByProductId(productId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProductReview(@RequestBody ProductReview review) {
        Optional <ProductReview> productReview = repository.findByProductIdAndUserId(review.getProductId(), review.getUserId());
        if(productReview.isPresent()) {
            RequestResponse response = new RequestResponse();
            response.setStatus("Fail");
            response.setMessage("You already reviewed this product!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            repository.save(review);
            RequestResponse response = new RequestResponse();
            response.setStatus("Ok");
            response.setMessage("Reviewed submitted!!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
