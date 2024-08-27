package com.ecommerce.server.repository;

import com.ecommerce.server.entity.Products;
import com.ecommerce.server.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

    @Query("SELECT new Products(p.id, p.name, p.originalPrice, p.discountRate, p.thumbnailUrl, p.price, p.brand, p.description, p.shortDescription) " +
            "FROM Products p, wish_list w " +
            "WHERE (p.id = w.productId) AND (w.userId = :userId) ")
    List<Products> findAllByUserId(@Param(value = "userId") Integer userId);
}
