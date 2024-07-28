package com.ecommerce.server.repository;

import com.ecommerce.server.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
    List<ProductReview> findAllByProductId(Integer productId);

    Optional<ProductReview> findByProductIdAndUserId(Integer productId, Integer userId);
}
