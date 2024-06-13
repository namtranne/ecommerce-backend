package com.ecommerce.server.service;

import com.ecommerce.server.entity.Products;
import com.ecommerce.server.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    public Page<Products> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productsRepository.findAllProducts(pageable);
    }
}
