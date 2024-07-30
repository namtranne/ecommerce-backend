package com.ecommerce.server.repository;

import com.ecommerce.server.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
    List<ProductReview> findAllByProductId(Integer productId);

    @Query("Select p from product_review p  where p.productId= :productId and p.userId = :userId")
    Optional<ProductReview> findByProductIdAndUserId(@Param(value="productId") Integer productId,@Param(value="userId") Integer userId);
}
