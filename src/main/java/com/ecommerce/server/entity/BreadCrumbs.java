package com.ecommerce.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "breadcrumbs")
public class BreadCrumbs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="category_id")
    private Integer categoryId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategory_od(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products products) {
        this.product = products;
    }
}
