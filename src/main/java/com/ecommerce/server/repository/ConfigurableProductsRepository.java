package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.ConfigurableProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableProductsRepository extends JpaRepository<ConfigurableProducts, Integer> {
}
