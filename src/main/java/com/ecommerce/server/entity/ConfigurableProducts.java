package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "configurable_products")
public class ConfigurableProducts {
    @Id
    private Integer id;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "inventory_status")
    private String inventoryStatus;

    private String name;

    private String option1;

    private String option2;

    @OneToMany
    @JoinColumn(name = "configurable_product_id")
    private List<ConfigurableProductImages> images;

}
