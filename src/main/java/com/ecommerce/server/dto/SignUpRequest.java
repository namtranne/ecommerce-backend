package com.ecommerce.server.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;


@AllArgsConstructor
@Getter
public class SignUpRequest {
    private String avatar;
    private String firstName;
    private String username;
    private String password;
    private String email;
    private String lastName;
    private Date birthDay;
    private String phoneNumber;
}
