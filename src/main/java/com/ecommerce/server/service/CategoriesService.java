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


    public List<Categories> getAllCategories() {
        return categoriesTree;
    }

    public List<Categories> getSubCategories(Integer parentId) {
        if(parentId == null) {
            return categoriesRepository.getRootCategories();
        }
        return categoriesRepository.getCategoriesByParentId(parentId);
    }
}
