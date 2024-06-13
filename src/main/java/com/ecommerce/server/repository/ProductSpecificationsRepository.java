package com.ecommerce.server.repository;

import com.ecommerce.server.entity.ProductSpecifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpecificationsRepository extends JpaRepository<ProductSpecifications, Integer> {
}
