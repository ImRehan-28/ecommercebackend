package com.rehan.ecommerce.service;


import com.rehan.ecommerce.entities.User;

import java.util.List;

public interface UserService {
        List<User> getAllUsers();
        User getUserById(Long id);
    }