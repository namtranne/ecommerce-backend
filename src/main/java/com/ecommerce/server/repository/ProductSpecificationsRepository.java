package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.ProductSpecifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpecificationsRepository extends JpaRepository<ProductSpecifications, Integer> {
}
