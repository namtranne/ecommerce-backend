package com.ecommerce.server.service;

import com.ecommerce.server.entity.Products;
import com.ecommerce.server.entity.WishList;
import com.ecommerce.server.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    private WishListRepository repository;

    public List<Products> findByUserId(Integer userId) {
        return repository.findAllByUserId(userId);
    }

    public void save(WishList wishList) {
        repository.save(wishList);
    }

    public void remove(Integer productId, Integer userId) {
        repository.deleteByProductIdAndUserId(productId, userId);
    }
}
