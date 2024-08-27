package com.ecommerce.server.dto;

import com.ecommerce.server.entity.Products;
import com.ecommerce.server.entity.WishList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class WishListResponseDTO {
    public int code;
    public List<Products> wishList;

    public WishListResponseDTO() {

    }
}
