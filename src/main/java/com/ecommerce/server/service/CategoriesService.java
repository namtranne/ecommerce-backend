package com.ecommerce.server.service;

import com.ecommerce.server.entity.Categories;
import com.ecommerce.server.entity.Products;
import com.ecommerce.server.repository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    CategoriesRepository categoriesRepository;

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

}
