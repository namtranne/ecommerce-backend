package com.ecommerce.server.repository;

import com.ecommerce.server.entity.BreadCrumbs;
import com.ecommerce.server.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BreadCrumbsRepository extends JpaRepository<BreadCrumbs, Integer> {

    @Query("SELECT new Products(b.product.id, b.product.name, b.product.originalPrice, b.product.discountRate, b.product.thumbnailUrl, b.product.price, b.product.brand, b.product.description, b.product.shortDescription) " +
            "FROM BreadCrumbs b " +
            "WHERE b.categoryId = :categoriesId")
    Page<Products> getProductsByCategoryId(@Param("categoriesId") Integer categoriesId, Pageable pageable);
}
