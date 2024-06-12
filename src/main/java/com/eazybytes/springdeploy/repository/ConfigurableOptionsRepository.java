package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.ConfigurableOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableOptionsRepository extends JpaRepository<ConfigurableOptions, Integer> {
}
