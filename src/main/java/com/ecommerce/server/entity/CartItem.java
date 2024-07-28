package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name="cart_item")
@AllArgsConstructor
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name="product_id")
    private Integer productId;

    @Column(name="product_config_id")
    private Integer configurableProductId;

    @Column(name = "option_1")
    private String option1;

    @Column(name="option_2")
    private String option2;

    @Column(name="image")
    private String image;

    private Integer quantity;

    public CartItem() {

    }
}