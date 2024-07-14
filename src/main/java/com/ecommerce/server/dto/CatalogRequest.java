package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CatalogRequest {
    private Integer categoryId;
    private Integer page;
    private String brand;
    private String keyWord;
    private Integer maxPrice;
    private Integer minPrice;
    private String sortBy;
    private String sortDir;
}
