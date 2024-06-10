package com.eazybytes.springdeploy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_warranty")
public class ProductWarranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "warranty_name")
    private String warrantyName;

    @Column(name = "warranty_value")
    private String warrantyValue;

    private String url;

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

    public String getWarrantyName() {
        return warrantyName;
    }

    public void setWarrantyName(String warrantyName) {
        this.warrantyName = warrantyName;
    }

    public String getWarrantyValue() {
        return warrantyValue;
    }

    public void setWarrantyValue(String warrantyValue) {
        this.warrantyValue = warrantyValue;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
