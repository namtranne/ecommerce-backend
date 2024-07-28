package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="user_id")
    private Integer userId;

    @Column(name="title")
    private String title;

    @Column(name="address_line_1")
    private String addressLine1;

    @Column(name="address_line_2")
    private String addressLine2;

    @Column(name="country")
    private String country;

    @Column(name="city")
    private String city;

    @Column(name="postal_code")
    private String postalCode;

    @Column(name="landmark")
    private String landmark;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="receiver_name")
    private String receiverName;

    public Address() {

    }
}
