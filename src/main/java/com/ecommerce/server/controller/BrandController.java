package com.ecommerce.server.controller;

import com.ecommerce.server.entity.Brand;
import com.ecommerce.server.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/brands")
public class BrandController {

    @Autowired
    BrandRepository repo;
    @GetMapping("")
    public List<Brand> getALlBrands() {
        return repo.findAll();
    }
}
