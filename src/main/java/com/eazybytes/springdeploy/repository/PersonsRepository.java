package com.eazybytes.springdeploy.repository;

import com.eazybytes.springdeploy.entity.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Persons, Integer> {
    Persons findFirstByPersonId(int id);
}
