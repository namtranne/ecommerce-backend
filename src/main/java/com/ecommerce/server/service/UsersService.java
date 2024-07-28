package com.ecommerce.server.service;

import com.ecommerce.server.entity.User;
import com.ecommerce.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UserRepository usersRepository;

    public User saveUser(User user) {
        return usersRepository.save(user);
    }

}