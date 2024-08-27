package com.ecommerce.server.dto;

import com.ecommerce.server.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GetOrdersDTO {
    public int code;
    public List<OrderDetails> orders;
}
