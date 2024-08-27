package com.ecommerce.server.controller;

import com.ecommerce.server.constant.HttpStatusCode;
import com.ecommerce.server.dto.GetOrdersDTO;
import com.ecommerce.server.dto.PaymentResponse;
import com.ecommerce.server.dto.RequestResponse;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/auth/order/user")
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

    @GetMapping("/admin/order")
    public ResponseEntity<GetOrdersDTO> getAllOrders() {
        try {
            List<OrderDetails> orders = orderService.findAll();
            GetOrdersDTO response = new GetOrdersDTO(HttpStatusCode.OK, orders);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception error) {
            GetOrdersDTO response = new GetOrdersDTO(HttpStatusCode.INTERNAL_SERVER_ERROR, null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/admin/order")
    public ResponseEntity<RequestResponse> update(@RequestBody OrderDetails order) {
        try {
            orderService.update(order);
            RequestResponse response = new RequestResponse();
            response.setMessage("Order update successfully");
            response.setStatus("OK");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e) {
            RequestResponse response = new RequestResponse();
            response.setMessage("There was an error when updating order");
            response.setStatus("ERROR");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
