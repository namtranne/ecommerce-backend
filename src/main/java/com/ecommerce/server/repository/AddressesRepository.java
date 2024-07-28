package com.ecommerce.server.repository;

import com.ecommerce.server.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressesRepository extends JpaRepository<Address, Long> {
    List<Address> findByUserId(Integer userId);
}