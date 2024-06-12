package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImagesRepository  extends JpaRepository<ProductImages, Integer> {
}
