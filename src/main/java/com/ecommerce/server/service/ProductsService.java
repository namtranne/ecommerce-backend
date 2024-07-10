package com.ecommerce.server.service;

import com.ecommerce.server.entity.BreadCrumbs;
import com.ecommerce.server.entity.Products;
import com.ecommerce.server.repository.BreadCrumbsRepository;
import com.ecommerce.server.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private BreadCrumbsRepository breadCrumbsRepository;

    public Page<Products> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productsRepository.findAllProducts(pageable);
    }

    public Page<Products> getProductsByCategoryId(int categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page-1, 24, Sort.by("product.price").descending());
        return breadCrumbsRepository.getProductsByCategoryId(categoryId, pageable);
    }

    @Cacheable(value="productCache", key="#productId")
    public Products getProductById(int productId) {
        return productsRepository.findById(productId);
    }

}
