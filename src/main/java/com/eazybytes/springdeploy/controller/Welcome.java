package com.eazybytes.springdeploy.controller;


import com.eazybytes.springdeploy.entity.Persons;
import com.eazybytes.springdeploy.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @Autowired
    PersonsRepository repo;

    @GetMapping("/welcome")
    public String welcome() {
        Persons person = repo.findFirstByPersonId(1);
        return "Welcome to spring project " + person.toString();
    }
}
