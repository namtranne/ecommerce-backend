package com.ecommerce.server.dto;

import com.ecommerce.server.entity.Products;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Setter
@Getter
public class CartDTO {
    public CartDTO() {
        
    }
    private Integer id;
    private String username;
    private Products product;
    private Integer configurableProductId;
    private String option1;
    private String option2;
    private String image;
    private Integer quantity;
}
