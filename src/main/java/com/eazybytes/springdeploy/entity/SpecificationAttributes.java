package com.eazybytes.springdeploy.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "product_specification_attributes")
public class SpecificationAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "specification_id")
    private int specificationId;

    private String name;

    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(int specificationId) {
        this.specificationId = specificationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
