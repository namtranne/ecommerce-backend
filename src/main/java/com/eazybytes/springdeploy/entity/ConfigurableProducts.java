package com.eazybytes.springdeploy.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "configurable_products")
public class ConfigurableProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "inventory_status")
    private String inventoryStatus;

    private String name;

    private String option1;

    private String option2;

    @OneToMany
    @JoinColumn(name = "configurable_product_id")
    private List<ConfigurableProductImages> images;

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

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public List<ConfigurableProductImages> getImages() {
        return images;
    }

    public void setImages(List<ConfigurableProductImages> images) {
        this.images = images;
    }
}
