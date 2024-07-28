package com.ecommerce.server.service;

import com.ecommerce.server.dto.CatalogRequest;
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

    public Page<Products> getProducts(CatalogRequest request) {
        int page = request.getPage();
        Pageable pageable;
        if (request.getSortBy() != null && request.getSortDir() != null) {
            Sort.Direction direction = request.getSortDir().equalsIgnoreCase("des") ? Sort.Direction.DESC : Sort.Direction.ASC;
            pageable = PageRequest.of(page, 24, Sort.by(direction, request.getSortBy()));
        } else {
            pageable = PageRequest.of(page, 24);
        }

        return productsRepository.findProductsByRequest(
                request.getBrand(),
                request.getKeyWord(),
                request.getMinPrice(),
                request.getMaxPrice(),
                pageable
        );
    }

    public Page<Products> getProductsByCategoryId(CatalogRequest request) {
        int page = request.getPage();
        Pageable pageable;
        if (request.getSortBy() != null && request.getSortDir() != null) {
            Sort.Direction direction = request.getSortDir().equalsIgnoreCase("des") ? Sort.Direction.DESC : Sort.Direction.ASC;
            pageable = PageRequest.of(page, 24, Sort.by(direction, request.getSortBy()));
        } else {
            pageable = PageRequest.of(page, 24);
        }

        return productsRepository.findProductsByCategory(
                request.getCategoryId(),
                request.getBrand(),
                request.getKeyWord(),
                request.getMinPrice(),
                request.getMaxPrice(),
                pageable
        );
    }

    @Cacheable(value="productCache", key="#productId")
    public Products getProductById(int productId) {
        return productsRepository.findById(productId);
    }

    public Products getProductCartById(Integer productId) {
        return productsRepository.getCartProductById(productId);
    }
}
