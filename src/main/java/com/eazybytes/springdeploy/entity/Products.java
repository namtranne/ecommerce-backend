package com.eazybytes.springdeploy.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "original_price")
    private int originalPrice;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "discount_rate")
    private int discountRate;

    @Column(name = "rating_average")
    private int ratingAverage;

    @Column(name = "favourite_count")
    private int favouriteCount;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @Column(name = "all_time_quantity_sold")
    private int quantitySold;

    @Column(name = "inventory_status")
    private String inventoryStatus;

    @Column(name = "review_count")
    private int reviewCount;

    private String description;
    private String name;
    private int Price;
    private String type;
    private int discount;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories category;

    @OneToMany
    @JoinColumn(name="product_id")
    private List<ProductImages> images;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductWarranty> warranties;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductSpecifications> specifications;


}
