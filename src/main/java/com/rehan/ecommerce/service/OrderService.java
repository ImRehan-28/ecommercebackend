package com.rehan.ecommerce.service;

import com.rehan.ecommerce.entities.Order;

import java.util.List;

public interface OrderService {

    // Place order
    public Order placeOrder() ;

    // Get all orders
    public List<Order> getAllOrders() ;
}
