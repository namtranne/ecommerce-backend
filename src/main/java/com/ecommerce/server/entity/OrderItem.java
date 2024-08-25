package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "order_items")
@Setter()
@Getter()
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="product_id")
    private Integer productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="option_1")
    private String option1;

    @Column(name="option_2")
    private String option2;

    private String image;
    private Integer quantity;
    private Integer price;
}
