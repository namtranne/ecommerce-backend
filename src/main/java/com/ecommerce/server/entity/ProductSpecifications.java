package com.ecommerce.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "product_specifications")
public class ProductSpecifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    private String name;

    @OneToMany
    @JoinColumn(name="specification_id")
    private List<SpecificationAttributes> attributes;
}
