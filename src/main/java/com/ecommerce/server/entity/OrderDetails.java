package com.ecommerce.server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "order_details")
@Setter()
@Getter()
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name="order_status")
    private String orderStatus;

    @Column(name="payment_status")
    private String paymentStatus;

    private Integer total;

    @OneToMany(mappedBy = "orderId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    @Column(name = "created_date")
    private Date createdDate = Date.valueOf(LocalDate.now());

    @Column(name = "updated_date")
    private Date updatedDate;

    private String address;

    @Column(name="user_name")
    private String username;

}
