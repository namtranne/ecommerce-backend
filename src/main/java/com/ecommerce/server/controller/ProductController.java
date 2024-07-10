package com.ecommerce.server.controller;

import com.ecommerce.server.entity.*;
import com.ecommerce.server.repository.*;
import com.ecommerce.server.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductImagesRepository imageRepo;

    @Autowired
    ProductsService productsService;

    @Autowired
    BrandRepository brandRepo;

    @Autowired
    CategoriesRepository categoriesRepo;

    @Autowired
    ProductWarrantyRepository warrantyRepo;

    @Autowired
    ConfigurableProductsRepository configRepo;

    @Autowired
    ConfigurableProductImagesRepository configImageRepo;

    @Autowired
    ConfigurableOptionsRepository optionRepo;

    @Autowired
    ConfigurableOptionValuesRepository optionValueRepo;

    @Autowired
    ProductSpecificationsRepository specificationRepo;

    @Autowired
    ProductSpecificationAttributesRepository specificationAttributesRepo;

    @GetMapping("")
    public Page<Products> getAllProducts(@RequestParam(value="page")int page, @RequestParam(value="limit") int limit) {
        return  productsService.getProducts(page,limit);
    }

    @GetMapping("/category")
    public Page<Products> getProductsByCategories(@RequestParam(value="categoryId", required = false) Integer categoryId, @RequestParam(value="page", required = false)Integer page, @RequestParam(value="limit", required = false) Integer limit) {
        if(categoryId == 0) {
            return productsService.getProducts(page,limit);
        }
        return productsService.getProductsByCategoryId(categoryId, page, limit);
    }

    @GetMapping("product-info")
    public Products getProduct(@RequestParam(value="id") int productId) {
        return productsService.getProductById(productId);
    }

}

