package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity(name = "wish_list")
@AllArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

   @Column(name="product_id")
    private Integer productId;

    public WishList() {

    }
}
