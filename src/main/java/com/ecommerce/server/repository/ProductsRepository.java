package com.ecommerce.server.repository;

import com.ecommerce.server.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    Products findById(int id);

    @Query("SELECT new Products(p.id, p.name, p.originalPrice, p.discountRate, p.thumbnailUrl, p.price, p.brand) FROM Products p")
    Page<Products> findAllProducts(Pageable pageable);

    @Query("SELECT new Products(p.id, p.name, p.originalPrice, p.discountRate, p.thumbnailUrl, p.price, p.brand) FROM Products p where p.category.id = :categoryId")
    List<Products> getProductsByCategoryId(@Param("categoryId") int categoryId);

    List<Products> findByCategoryIdIn(List<Integer> categoryIds);
}
