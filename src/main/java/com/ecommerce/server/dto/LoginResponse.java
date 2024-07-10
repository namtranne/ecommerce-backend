package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginResponse {
    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
