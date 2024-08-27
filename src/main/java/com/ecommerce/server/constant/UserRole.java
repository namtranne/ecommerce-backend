package com.ecommerce.server.constant;

import lombok.Getter;

public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");
    private final String displayName;
    UserRole(String displayName) {
        this.displayName = displayName;
    }
    @Override
    public String toString() {
        return displayName;
    }
}
