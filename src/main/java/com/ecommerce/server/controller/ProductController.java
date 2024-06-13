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

}

