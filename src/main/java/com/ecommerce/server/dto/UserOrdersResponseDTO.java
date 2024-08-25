package com.ecommerce.server.dto;

import com.ecommerce.server.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UserOrdersResponseDTO {
    public int code;
    public List<OrderDetails> orders;

    public UserOrdersResponseDTO() {

    }
}
