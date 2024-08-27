package com.ecommerce.server.dto;

import com.ecommerce.server.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class GetUsersDTO {
    public int code;
    public List<User> users;
}
