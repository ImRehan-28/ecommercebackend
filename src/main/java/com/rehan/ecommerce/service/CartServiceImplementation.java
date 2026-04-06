package com.rehan.ecommerce.service;

import com.rehan.ecommerce.entities.Cart;
import com.rehan.ecommerce.entities.Product;
import com.rehan.ecommerce.entities.User;
import com.rehan.ecommerce.repository.CartRepository;
import com.rehan.ecommerce.repository.ProductRepository;
import com.rehan.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImplementation implements CartService{

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private UserRepository userRepo;

    // Add item to cart
    public Cart addToCart(Long productId, int quantity) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(quantity);

        return cartRepo.save(cart);
    }

    @Override
    public List<Cart> getCartItems(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartRepo.findByUser(user);
    }

    // Remove item from cart
    public void removeFromCart(Long cartId)
    {
        cartRepo.deleteById(cartId);
    }

    // Clear cart
    public void clearCart() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        cartRepo.deleteAll(cartRepo.findByUser(user));
    }
}
