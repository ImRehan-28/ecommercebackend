package com.rehan.ecommerce.service;

import com.rehan.ecommerce.entities.Cart;

import java.util.List;

public interface CartService {

    // Add item to cart
    public Cart addToCart(Long productId, int quantity);

    // Get all cart items
    public List<Cart> getCartItems(String email) ;

    // Remove item from cart
    public void removeFromCart(Long cartId) ;

    // Clear cart
    public void clearCart() ;
}
