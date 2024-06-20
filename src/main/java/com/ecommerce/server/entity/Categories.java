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

    @Column(name = "is_leaf")
    private boolean isLeaf;

    @ManyToOne
    @JoinColumn(name = "parent_category_id", referencedColumnName = "id")
    private Categories parentCategory;

    private String image;

    // Default constructor
    public Categories() { }

    // Constructor for partial fields
    public Categories(Integer id, String url, String name, String image) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.image = image;
    }

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

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public Categories getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Categories parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

