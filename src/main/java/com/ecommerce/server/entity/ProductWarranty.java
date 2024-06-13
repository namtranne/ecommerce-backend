package com.ecommerce.server.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_warranty")
public class ProductWarranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "warranty_name")
    private String warrantyName;

    @Column(name = "warranty_value")
    private String warrantyValue;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
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
