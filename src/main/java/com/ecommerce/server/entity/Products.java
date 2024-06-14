package com.ecommerce.server.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
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

    @OneToMany
    @JoinColumn(name="product_id")
    private List<ProductImages> images;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductWarranty> warranties;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductSpecifications> specifications;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ConfigurableProducts> configurableProducts;

    public Products() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public int getRatingAverage() {
        return ratingAverage;
    }

    public void setRatingAverage(int ratingAverage) {
        this.ratingAverage = ratingAverage;
    }

    public int getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(int favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public Products(Integer id, String name, int originalPrice, int discountRate, String thumbnailUrl, int price, Brand brand) {
        this.id = id;
        this.name = name;
        this.originalPrice = originalPrice;
        this.discountRate = discountRate;
        this.thumbnailUrl = thumbnailUrl;
        this.price = price;
        this.brand = brand;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public List<ProductImages> getImages() {
        return images;
    }

    public void setImages(List<ProductImages> images) {
        this.images = images;
    }

    public List<ProductWarranty> getWarranties() {
        return warranties;
    }

    public void setWarranties(List<ProductWarranty> warranties) {
        this.warranties = warranties;
    }

    public List<ProductSpecifications> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<ProductSpecifications> specifications) {
        this.specifications = specifications;
    }

    public List<ConfigurableProducts> getConfigurableProducts() {
        return configurableProducts;
    }

    public void setConfigurableProducts(List<ConfigurableProducts> configurableProducts) {
        this.configurableProducts = configurableProducts;
    }

    public List<ConfigurableOptions> getConfigurableOptions() {
        return configurableOptions;
    }

    public void setConfigurableOptions(List<ConfigurableOptions> configurableOptions) {
        this.configurableOptions = configurableOptions;
    }

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ConfigurableOptions> configurableOptions;
}
