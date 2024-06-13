package com.ecommerce.server.repository;

import com.ecommerce.server.entity.ConfigurableProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurableProductImagesRepository extends JpaRepository<ConfigurableProductImages, Integer> {
}
