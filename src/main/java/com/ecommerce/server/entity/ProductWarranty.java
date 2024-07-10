package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Entity
@Setter
@Getter
@Table(name = "product_warranty")
public class ProductWarranty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "warranty_name")
    private String warrantyName;

    @Column(name = "warranty_value")
    private String warrantyValue;

    private String url;
}
