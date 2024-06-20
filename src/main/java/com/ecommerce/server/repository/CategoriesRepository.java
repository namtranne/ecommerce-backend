package com.ecommerce.server.repository;

import com.ecommerce.server.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
    @Query("SELECT new Categories(c.id, c.url, c.name, c.image) FROM Categories c")
    List<Categories> getAllCategories();

    @Query("SELECT new Categories(c.id, c.url, c.name, c.image) FROM Categories c where c.parentCategory is null")
    List<Categories> getRootCategories();

    @Query("SELECT new Categories(c.id, c.url, c.name, c.image) FROM Categories c WHERE c.parentCategory.id = :parentId")
    List<Categories> getCategoriesByParentId(@Param("parentId") Integer parentId);

}
