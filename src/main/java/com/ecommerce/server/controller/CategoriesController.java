package com.ecommerce.server.controller;

import com.ecommerce.server.entity.Categories;
import com.ecommerce.server.entity.Products;
import com.ecommerce.server.service.CategoriesService;
import com.ecommerce.server.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    CategoriesService categoriesService;

    @GetMapping("/all")
    public List<Categories> getAllCategories() {
        return categoriesService.getAllCategories();
    }

    @GetMapping("/subcategories")
    public List<Categories> getSubCategories(@RequestParam("parentId") Integer parentId) {
        return categoriesService.getSubCategories(parentId);
    }
}
