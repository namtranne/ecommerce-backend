package com.ecommerce.server.controller;

import com.ecommerce.server.entity.Categories;
import com.ecommerce.server.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    CategoriesService categoriesService;
    @GetMapping("")
    public List<Categories> getAllCategories() {
        return categoriesService.getAllCategories();
    }
}
