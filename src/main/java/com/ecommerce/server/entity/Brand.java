package com.ecommerce.server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "brand")
public class Brand {
    @Id
    private Integer id;

    private String name;
}
