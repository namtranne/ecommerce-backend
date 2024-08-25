package com.ecommerce.server.service;

import com.ecommerce.server.constant.OrderStatus;
import com.ecommerce.server.constant.PaymentMethod;
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

    public OrderDetails createOrder(List<CartItem> cartItems, Integer userId) {
        OrderDetails order = new OrderDetails();
        order.setUserId(userId);
        order.setPaymentMethod(PaymentMethod.VN_PAY.name());
        OrderDetails savedOrder = orderDetailsRepository.save(order);
        order.setOrderStatus(OrderStatus.WAITING_FOR_PAYMENT.getDisplayName());
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
}
