package com.ecommerce.server.repository;

import com.ecommerce.server.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
    List<OrderDetails> getByUserId(Integer userId);

    List<OrderDetails> findByUserId(Integer userId);
}
