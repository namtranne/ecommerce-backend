package com.eazybytes.springdeploy;

import com.eazybytes.springdeploy.entity.Persons;
import com.eazybytes.springdeploy.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {

    @Autowired
    PersonsRepository repo;

    @Override
    public void run(String... args) throws Exception {
        Persons person = repo.findFirstByPersonId(1);
        System.out.println(person.toString());
    }
}
