package com.ecommerce.server.controller;


import com.ecommerce.server.entity.Users;
import com.ecommerce.server.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
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