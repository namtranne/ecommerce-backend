package com.ecommerce.server.repository;

import com.ecommerce.server.entity.ProductWarranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductWarrantyRepository extends JpaRepository<ProductWarranty, Integer> {
}
