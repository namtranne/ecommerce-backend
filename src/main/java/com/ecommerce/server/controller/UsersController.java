package com.eazybytes.springdeploy.controller;


import com.eazybytes.springdeploy.entity.Users;
import com.eazybytes.springdeploy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("welcome")
    public String welcome() {
        return "Welcome to ECommerce website";
    }

    @PostMapping("create")
    public int createUser(@RequestBody Users user) {
        return 123;
    }
}