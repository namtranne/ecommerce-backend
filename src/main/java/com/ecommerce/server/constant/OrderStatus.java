package com.ecommerce.server.constant;

import lombok.Getter;

@Getter
public enum OrderStatus {
    WAITING_FOR_PAYMENT("Waiting for Payment"),
    PAID("Paid"),
    PREPARING("Preparing"),
    SHIPPING("Shipping"),
    DELIVERED("Delivered"),
    CANCELLED("Cancelled"),
    RETURNED("Returned"),
    REFUNDED("Refunded");
    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}