package com.eazybytes.springdeploy.controller;

import com.eazybytes.springdeploy.entity.*;
import com.eazybytes.springdeploy.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    ProductImagesRepository imageRepo;

    @Autowired
    ProductsRepository productsRepos;

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

    Set<Integer> set = new HashSet<>();

    @PostMapping("create")
    private int testReceiveProduct(@RequestBody Products product, @RequestParam(value = "categoryId") Integer categoryId, @RequestParam(value="brandId") Integer brandId) {
        Brand brand = brandRepo.getReferenceById(brandId);
        Categories category = categoriesRepo.getReferenceById(categoryId);
        product.setBrand(brand);
        product.setCategory(category);
        return productsRepos.save(product).getId();
    }

    @PostMapping("categories/create")
    public int createCategories(@RequestBody Categories category, @RequestParam(value = "parentId") Integer parentId) {
        Categories parentCategory = null;
        if(parentId != 0) {
            parentCategory = categoriesRepo.getReferenceById(parentId);
        }
        category.setParentCategories(parentCategory);
        return categoriesRepo.save(category).getId();
    }

    @PostMapping("image")
    public int createImage(@RequestBody List<ProductImages> images) {
        for(ProductImages image : images) {
            ProductImages saveImage = imageRepo.save(image);
        }
        return images.size();
    }

    @PostMapping("brand")
    private int createBrand(@RequestBody Brand brand) {
        Brand saveBrand = brandRepo.save(brand);
        return saveBrand.getId();
    }

    @PostMapping("warranty")
    private int createWarranty(@RequestBody ProductWarranty warranty) {
        warrantyRepo.save(warranty);
        return 1;
    }

    @PostMapping("config")
    private int createConfigProduct(@RequestBody ConfigurableProducts config) {
        configRepo.save(config);
        return 1;
    }

    @PostMapping("config/image")
    private int createConfigProductImage(@RequestBody ConfigurableProductImages image) {
        configImageRepo.save(image);
        return 1;
    }

    @PostMapping("option")
    private int createOption(@RequestBody ConfigurableOptions option) {
        ConfigurableOptions saveOption = optionRepo.save(option);
        return saveOption.getId();
    }

    @PostMapping("option/value")
    private int createOptionValue(@RequestBody ConfigurableOptionValues value) {
        ConfigurableOptionValues saveValue = optionValueRepo.save(value);
        return saveValue.getId();
    }

    @PostMapping("specification")
    private int createSpecification(@RequestBody ProductSpecifications spec) {
        ProductSpecifications saveSpec = specificationRepo.save(spec);
        return saveSpec.getId();
    }

    @PostMapping("specification/attribute")
    private int createSpecAttribute(@RequestBody SpecificationAttributes attributes) {
        SpecificationAttributes saveAttribute = specificationAttributesRepo.save(attributes);
        return attributes.getId();
    }

}



