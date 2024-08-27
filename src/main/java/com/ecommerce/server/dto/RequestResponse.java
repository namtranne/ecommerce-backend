package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RequestResponse {
    public RequestResponse() {}
    private String status;
    private String message;
}