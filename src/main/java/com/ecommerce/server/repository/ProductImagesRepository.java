package com.ecommerce.server.repository;

import com.ecommerce.server.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImagesRepository  extends JpaRepository<ProductImages, Integer> {
}
