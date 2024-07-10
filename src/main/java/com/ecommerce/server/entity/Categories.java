package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String url;
    private String name;

    @Column(name = "is_leaf")
    private boolean isLeaf;

    @ManyToOne
    @JoinColumn(name = "parent_category_id", referencedColumnName = "id")
    private Categories parentCategory;

    private String image;

    // Default constructor
    public Categories() { }

    // Constructor for partial fields
    public Categories(Integer id, String url, String name, String image) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.image = image;
    }
}

