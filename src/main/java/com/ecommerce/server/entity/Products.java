package com.ecommerce.server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Products {
    @Id
    private Integer id;

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
    private int price;
    private String type;
    private int discount;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories category;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private List<ProductImages> images;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<ProductWarranty> warranties;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<ProductSpecifications> specifications;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<ConfigurableProducts> configurableProducts;

    public Products(Integer id, int originalPrice, int discountRate, String name, int price) {
        this.id = id;
        this.originalPrice = originalPrice;
        this.discountRate = discountRate;
        this.name = name;
        this.price = price;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private List<ConfigurableOptions> configurableOptions;

    public Products() {

    }

    public Products(Integer id, String name, int originalPrice, int discountRate, String thumbnailUrl, int price, Brand brand, String description, String shortDescription) {
        this.id = id;
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountRate = discountRate;
        this.thumbnailUrl = thumbnailUrl;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.shortDescription = shortDescription;
    }

}
