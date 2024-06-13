package com.ecommerce.server.repository;

import com.ecommerce.server.entity.ConfigurableOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableOptionsRepository extends JpaRepository<ConfigurableOptions, Integer> {
}
