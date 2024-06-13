package com.ecommerce.server.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private String name;
}