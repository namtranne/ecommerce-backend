package com.ecommerce.server.constant;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    PAID("Paid"),
    PENDING("Pending"),
    CANCElED("Canceled");
    private final String displayName;
    PaymentStatus(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}