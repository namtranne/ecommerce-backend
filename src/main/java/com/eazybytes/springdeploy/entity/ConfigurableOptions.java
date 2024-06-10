package com.eazybytes.springdeploy.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "configurable_options")
public class ConfigurableOptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "product_id")
    private int productId;

    @OneToMany
    @JoinColumn(name = "option_id")
    List<OptionValues> values;
}
