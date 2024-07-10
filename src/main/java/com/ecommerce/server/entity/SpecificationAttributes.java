package com.ecommerce.server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product_specification_attributes")
public class SpecificationAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "specification_id")
    private Integer specificationId;

    private String name;

    private String value;
}
