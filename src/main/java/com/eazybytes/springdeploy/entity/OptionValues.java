package com.eazybytes.springdeploy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "option_values")
public class OptionValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "option_id")
    private int optionId;

    private String label;
}
