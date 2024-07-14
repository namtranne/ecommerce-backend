package com.ecommerce.server.controller;

import com.ecommerce.server.dto.CatalogRequest;
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

//    @GetMapping("")
//    public Page<Products> getAllProducts(@RequestParam(value="page")int page) {
//        return  productsService.getProducts(page);
//    }

    @PostMapping("/category")
    public Page<Products> getProductsByCategories(@RequestBody CatalogRequest request) {
        if(request.getCategoryId() == 0) {
            return productsService.getProducts(request);
        }
        return productsService.getProductsByCategoryId(request);
    }

    @GetMapping("product-info")
    public Products getProduct(@RequestParam(value="id") int productId) {
        return productsService.getProductById(productId);
    }

}

