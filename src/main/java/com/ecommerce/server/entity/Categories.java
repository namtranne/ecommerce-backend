package com.ecommerce.server.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;
    private String name;

    @Column(name = "parent_category_id")
    private Integer parentCategoryId;

    @OneToMany(mappedBy = "parentCategoryId")
    private List<Categories> childrenCategories;

    // Default constructor
    public Categories() { }

    public Categories(Integer id, String url, String name, List<Categories> childrenCategories) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.childrenCategories = childrenCategories;
    }

    // Constructor for partial fields
    public Categories(Integer id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public List<Categories> getChildrenCategories() {
        return childrenCategories;
    }

    public void setChildrenCategories(List<Categories> childrenCategories) {
        this.childrenCategories = childrenCategories;
    }
}

