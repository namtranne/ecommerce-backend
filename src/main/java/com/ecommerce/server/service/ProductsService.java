package com.eazybytes.springdeploy.service;

import com.eazybytes.springdeploy.entity.Products;
import com.eazybytes.springdeploy.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public Products saveUser(Products product) {
        return productsRepository.save(product);
    }
}
