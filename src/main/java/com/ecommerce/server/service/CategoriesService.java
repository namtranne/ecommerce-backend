package com.ecommerce.server.service;

import com.ecommerce.server.entity.Categories;
import com.ecommerce.server.entity.Products;
import com.ecommerce.server.repository.CategoriesRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    List<Categories> categoriesTree = new LinkedList<>();

//    @PostConstruct
//    public void init() {
//        categoriesTree = categoriesRepository.getAllCategories();
//    }

    public List<Categories> getAllCategories() {
        return categoriesTree;
    }

    public List<Categories> getSubCategories(Integer parentId) {
        return categoriesRepository.getCategoriesByParentId(parentId);
    }
}
