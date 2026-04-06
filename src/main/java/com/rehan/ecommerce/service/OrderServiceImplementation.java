package com.rehan.ecommerce.service;

import com.rehan.ecommerce.entities.Cart;
import com.rehan.ecommerce.entities.Order;
import com.rehan.ecommerce.entities.OrderItem;
import com.rehan.ecommerce.entities.User;
import com.rehan.ecommerce.repository.CartRepository;
import com.rehan.ecommerce.repository.OrderRepository;
import com.rehan.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImplementation implements OrderService{
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private UserRepository userRepo;

    // Place order
    public Order placeOrder() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<Cart> cartItems = cartRepo.findByUser(user);

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();
        order.setUser(user);
        order.setStatus("PLACED");

        List<OrderItem> orderItems = new ArrayList<>();
        double total = 0;

        for (Cart cart : cartItems) {

            OrderItem item = new OrderItem();
            item.setProduct(cart.getProduct());
            item.setQuantity(cart.getQuantity());
            item.setPrice(cart.getProduct().getPrice());
            item.setOrder(order);

            total += cart.getProduct().getPrice() * cart.getQuantity();

            orderItems.add(item);
        }

        order.setItems(orderItems);
        order.setTotalPrice(total);

        Order saved = orderRepo.save(order);

        cartRepo.deleteAll(cartItems);

        return saved;
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
