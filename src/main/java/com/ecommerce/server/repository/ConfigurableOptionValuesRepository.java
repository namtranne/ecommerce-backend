package com.ecommerce.server.repository;

import com.ecommerce.server.entity.ConfigurableOptionValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableOptionValuesRepository extends JpaRepository<ConfigurableOptionValues, Integer> {
}
