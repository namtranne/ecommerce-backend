package com.ecommerce.server.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {

    @Id
    private Integer id;

    private String url;
    private String name;

    public Categories() {

    }

    public Categories(Integer id, String url, String name) {
        this.id = id;
        this.url = url;
        this.name = name;
    }

    public Categories(int id, String name, String url, List<Categories> childrenCategories) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.childrenCategories = childrenCategories;
    }

    public void setId(Integer id) {
        this.id = id;
    }


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

//    public Categories getParentCategories() {
//        return parentCategories;
//    }
//
//    public void setParentCategories(Categories parentCategories) {
//        this.parentCategories = parentCategories;
//    }

//    @ManyToOne
//    @JoinColumn(name="parent_category_id", referencedColumnName = "id")
//    Categories parentCategories;

    @OneToMany
    @JoinColumn(name="parent_category_id")
    List<Categories> childrenCategories;

    public List<Categories> getChildrenCategories() {
        return childrenCategories;
    }

    public void setChildrenCategories(List<Categories> childrenCategories) {
        this.childrenCategories = childrenCategories;
    }
}
