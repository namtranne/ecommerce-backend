package com.ecommerce.server.repository;

import com.ecommerce.server.entity.ConfigurableProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableProductsRepository extends JpaRepository<ConfigurableProducts, Integer> {
}
