package com.eazybytes.springdeploy.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product_specifications")
public class ProductSpecifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    private String name;

    @OneToMany
    @JoinColumn(name="specification_id")
    private List<SpecificationAttributes> attributes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
