package com.ecommerce.server.cache;

import com.ecommerce.server.entity.Products;
import com.ecommerce.server.repository.ProductsRepository;
import com.ecommerce.server.service.ProductsService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableCaching
public class CacheConfig {
    @Autowired
    CacheManager cacheManager;
    
}
