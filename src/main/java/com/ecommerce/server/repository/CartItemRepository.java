package com.ecommerce.server.repository;

import com.ecommerce.server.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    @Query("SELECT ci FROM cart_item ci WHERE ci.productId = :productId AND ci.configurableProductId = :configurableProductId")
    Optional<CartItem> findByProductIdAndConfigurableProductId(@Param("productId") Integer productId, @Param("configurableProductId") Integer configurableProductId);

    List<CartItem> findAllByUserId(Integer userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM cart_item ci WHERE ci.userId = :userId")
    void deleteAllByUserId(@Param("userId") Integer userId);
}
