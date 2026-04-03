package com.rehan.ecommerce.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.rehan.ecommerce.dto.request.CartRequestDTO;
import com.rehan.ecommerce.entities.Cart;
import com.rehan.ecommerce.repository.CartRepository;
import com.rehan.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
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