package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name="product_review")
@Getter
@Setter
@AllArgsConstructor
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="product_id")
    private Integer productId;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="content")
    private String content;

    public ProductReview() {

    }
}
