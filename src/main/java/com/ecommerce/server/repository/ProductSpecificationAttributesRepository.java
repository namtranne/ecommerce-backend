package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.SpecificationAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpecificationAttributesRepository extends JpaRepository<SpecificationAttributes, Integer> {
}
