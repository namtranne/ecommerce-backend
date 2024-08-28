package com.ecommerce.server.service;

import com.ecommerce.server.constant.OrderStatus;
import com.ecommerce.server.constant.PaymentMethod;
import com.ecommerce.server.constant.PaymentStatus;
import com.ecommerce.server.dto.PaymentRequestDTO;
import com.ecommerce.server.entity.CartItem;
import com.ecommerce.server.entity.OrderDetails;
import com.ecommerce.server.entity.OrderItem;
import com.ecommerce.server.entity.Products;
import com.ecommerce.server.repository.OrderDetailsRepository;
import com.ecommerce.server.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired ProductsService productService;

    public OrderDetails createOrder(List<CartItem> cartItems, Integer userId, String username, PaymentRequestDTO paymentRequestDTO) {
        OrderDetails order = new OrderDetails();
        order.setUserId(userId);
        order.setPaymentMethod(paymentRequestDTO.getPaymentMethod());
        order.setUsername(username);
        order.setAddress(paymentRequestDTO.getAddress());
        if(paymentRequestDTO.getPaymentMethod().equals(PaymentMethod.CASH.toString())) {
            order.setOrderStatus(OrderStatus.PREPARING.getDisplayName());
        }
        else {
            order.setOrderStatus(OrderStatus.WAITING_FOR_PAYMENT.getDisplayName());
        }
        order.setPaymentStatus(PaymentStatus.PENDING.toString());
        OrderDetails savedOrder = orderDetailsRepository.save(order);
        List<OrderItem> orderItems = new LinkedList<>();
        int amount = 0;
        for(CartItem cartItem : cartItems) {
            Products product = productService.getProductCartById(cartItem.getProductId());
            amount+=product.getPrice()*cartItem.getQuantity();
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(product.getId());
            orderItem.setOrderId(savedOrder.getId());
            orderItem.setImage(cartItem.getImage());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setOption1(cartItem.getOption1());
            orderItem.setOption2(cartItem.getOption2());
            orderItem.setProductName(product.getName());
            orderItem.setPrice(product.getPrice());
            orderItems.add(orderItem);
        }
        savedOrder.setOrderItems(orderItems);
        savedOrder.setTotal(amount);
        return orderDetailsRepository.save(savedOrder);
    }

    public List<OrderDetails> getUserOrders(Integer userId) {
        return orderDetailsRepository.getByUserId(userId);
    }

    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    public void update(OrderDetails order) {
        orderDetailsRepository.save(order);
    }

    public List<OrderDetails> findByUserId(Integer userId) {
        return orderDetailsRepository.findByUserId(userId);
    }
}
