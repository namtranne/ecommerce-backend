package com.eazybytes.springdeploy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String url;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Categories getParentCategories() {
        return parentCategories;
    }

    public void setParentCategories(Categories parentCategories) {
        this.parentCategories = parentCategories;
    }

    @ManyToOne
    @JoinColumn(name="parent_category_id", referencedColumnName = "id")
    Categories parentCategories;
}
