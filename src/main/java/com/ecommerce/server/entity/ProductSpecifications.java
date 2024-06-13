package com.ecommerce.server.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product_specifications")
public class ProductSpecifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    private String name;

    @OneToMany
    @JoinColumn(name="specification_id")
    private List<SpecificationAttributes> attributes;

    public List<SpecificationAttributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<SpecificationAttributes> attributes) {
        this.attributes = attributes;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
