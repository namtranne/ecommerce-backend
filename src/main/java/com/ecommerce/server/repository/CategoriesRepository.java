package com.ecommerce.server.repository;

import com.ecommerce.server.entity.Categories;
import com.ecommerce.server.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
    @Query("SELECT new Categories(c.id, c.name, c.url) FROM Categories c where c.parentCategories is null")
    List<Categories> getAllCategories();

}
