package com.ecommerce.server.dto;

import com.ecommerce.server.entity.Categories;

import java.util.List;

public class CategoriesDTO {
    private Categories currentCategory;
    private List<Categories> subCategories;

    public Categories getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Categories currentCategories) {
        this.currentCategory = currentCategories;
    }

    public List<Categories> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Categories> subCategories) {
        this.subCategories = subCategories;
    }
}
