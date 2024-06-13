package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.ConfigurableProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableProductImagesRepository extends JpaRepository<ConfigurableProductImages, Integer> {
}
