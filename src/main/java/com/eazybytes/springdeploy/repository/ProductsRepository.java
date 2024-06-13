package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
    Products findById(int id);
}
