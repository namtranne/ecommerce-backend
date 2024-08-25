package com.ecommerce.server.controller;

import com.ecommerce.server.constant.HttpStatusCode;
import com.ecommerce.server.dto.PaymentResponse;
import com.ecommerce.server.dto.UserOrdersResponseDTO;
import com.ecommerce.server.entity.OrderDetails;
import com.ecommerce.server.entity.User;
import com.ecommerce.server.security.CustomUserDetails;
import com.ecommerce.server.service.OrderService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/auth/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/user")
    public ResponseEntity<UserOrdersResponseDTO> getUserOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails userDetails) {
            Integer userId = userDetails.getUser().getId();
            List<OrderDetails> orders = orderService.getUserOrders(userId);
            UserOrdersResponseDTO response = new UserOrdersResponseDTO();
            response.setCode(HttpStatusCode.OK);
            response.setOrders(orders);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        //need to handle error
        UserOrdersResponseDTO response = new UserOrdersResponseDTO();
        response.setCode(HttpStatusCode.UNAUTHORIZED);
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}
