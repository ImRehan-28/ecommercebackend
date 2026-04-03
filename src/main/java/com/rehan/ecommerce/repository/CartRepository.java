package com.rehan.ecommerce.repository;

import com.rehan.ecommerce.entities.Cart;
import com.rehan.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findByUser(User user);
}
