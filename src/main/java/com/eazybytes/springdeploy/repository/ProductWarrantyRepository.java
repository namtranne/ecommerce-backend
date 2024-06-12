package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.ProductWarranty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductWarrantyRepository extends JpaRepository<ProductWarranty, Integer> {
}
