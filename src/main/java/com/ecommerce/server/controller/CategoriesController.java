package com.ecommerce.server.controller;

import com.ecommerce.server.dto.CategoriesDTO;
import com.ecommerce.server.entity.Categories;
import com.ecommerce.server.entity.Products;
import com.ecommerce.server.repository.CategoriesRepository;
import com.ecommerce.server.service.CategoriesService;
import com.ecommerce.server.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/categories")
public class CategoriesController {
    @Autowired
    CategoriesService categoriesService;

    @Autowired
    CategoriesRepository repo;

    List<Categories> allCategories;

    @GetMapping("/all")
    public List<Categories> getAllCategories() {
        return repo.getAllCategories();
    }

    @GetMapping("/subcategories")
    public List<Categories> getSubCategories(@RequestParam(value = "parentId", required = false) Integer parentId) {
        return categoriesService.getSubCategories(parentId);
    }

    @GetMapping("/products-page-data")
    public CategoriesDTO getProductsPageCategories(@RequestParam(value = "id", required = false) Integer categoryId) {
        CategoriesDTO dto = new CategoriesDTO();
        if(categoryId != 0) {
            Optional<Categories> currentCategories = repo.findById(categoryId);
            currentCategories.ifPresent(dto::setCurrentCategory);
            dto.setSubCategories(categoriesService.getSubCategories(categoryId));
            return dto;
        }
        dto.setSubCategories(categoriesService.getSubCategories(null));
        return dto;
    }
}
