package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.ConfigurableOptionValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableOptionValuesRepository extends JpaRepository<ConfigurableOptionValues, Integer> {
}
