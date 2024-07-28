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

    @Query("SELECT new Products(p.id, p.originalPrice, p.discount, p.name, p.price) FROM Products p WHERE p.id = :productId")
    Products getCartProductById(@Param("productId") Integer productId);


    @Query("SELECT new Products(p.id, p.name, p.originalPrice, p.discountRate, p.thumbnailUrl, p.price, p.brand, p.description, p.shortDescription) FROM Products p")
    Page<Products> findAllProducts(Pageable pageable);

    @Query("SELECT new Products(p.id, p.name, p.originalPrice, p.discountRate, p.thumbnailUrl, p.price, p.brand, p.description, p.shortDescription) " +
            "FROM Products p " +
            "WHERE (p.brand.name LIKE %:brand%) " +
            "AND (:keyWord IS NULL OR p.name LIKE %:keyWord%) " +
            "AND (:minPrice IS NULL OR p.price >= :minPrice) " +
            "AND (:maxPrice IS NULL OR p.price <= :maxPrice)")
    Page<Products> findProductsByRequest(
            @Param("brand") String brand,
            @Param("keyWord") String keyWord,
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice,
            Pageable pageable
    );

    @Query("SELECT new Products(product.id, product.name, product.originalPrice, product.discountRate, product.thumbnailUrl, product.price, product.brand, product.description, product.shortDescription) " +
            "FROM Products product " +
            "JOIN BreadCrumbs b on b.product.id = product.id WHERE b.categoryId =:categoryId " +
            "AND (product.brand.name LIKE %:brand%) " +
            "AND (product.name LIKE %:keyWord%) " +
            "AND (product.price >= :minPrice) " +
            "AND (product.price <= :maxPrice) ")
    Page<Products> findProductsByCategory(
            @Param("categoryId") Integer categoryId,
            @Param("brand") String brand,
            @Param("keyWord") String keyWord,
            @Param("minPrice") Integer minPrice,
            @Param("maxPrice") Integer maxPrice,
            Pageable pageable
    );
}
