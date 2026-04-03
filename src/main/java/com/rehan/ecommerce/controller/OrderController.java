package com.rehan.ecommerce.controller;

import com.rehan.ecommerce.entities.Order;
import com.rehan.ecommerce.repository.OrderRepository;
import com.rehan.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService repo;

    @PostMapping
    public Order placeOrder() {
        return repo.placeOrder();
    }
}
