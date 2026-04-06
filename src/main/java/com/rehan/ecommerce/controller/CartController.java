package com.rehan.ecommerce.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rehan.ecommerce.dto.request.CartRequestDTO;
import com.rehan.ecommerce.entities.Cart;
import com.rehan.ecommerce.service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping
    public List<Cart> getCart() {

        String email = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return service.getCartItems(email);  // ✅ correct method name
    }


    @PostMapping
    public Cart addToCart(@RequestBody CartRequestDTO request) {
        return service.addToCart(request.getProductId(), request.getQuantity());
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        service.removeFromCart(id);
    }
}