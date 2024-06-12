package com.eazybytes.springdeploy.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "configurable_product_images")
public class ConfigurableProductImages {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "configurable_product_id")
    private int configurableProductId;

    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConfigurableProductId() {
        return configurableProductId;
    }

    public void setConfigurableProductId(int configurableProductId) {
        this.configurableProductId = configurableProductId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
