package com.ecommerce.server.repository;

import com.ecommerce.server.entity.SpecificationAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpecificationAttributesRepository extends JpaRepository<SpecificationAttributes, Integer> {
}
