package com.ecommerce.server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
public class UserDetailRequest {
    private Date birthDay;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
