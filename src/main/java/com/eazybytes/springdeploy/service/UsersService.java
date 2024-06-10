package com.eazybytes.springdeploy.service;

import com.eazybytes.springdeploy.entity.Users;
import com.eazybytes.springdeploy.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }
}