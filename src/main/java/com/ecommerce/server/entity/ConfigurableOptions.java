package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "configurable_options")
public class ConfigurableOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    private String code;

    @OneToMany
    @JoinColumn(name = "option_id")
    List<ConfigurableOptionValues> values;
}
