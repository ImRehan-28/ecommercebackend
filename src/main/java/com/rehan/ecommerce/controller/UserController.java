package com.rehan.ecommerce.controller;

import com.rehan.ecommerce.dto.response.UserResponseDTO;
import com.rehan.ecommerce.entities.User;
import com.rehan.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    // Get all users (Admin only ideally)
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return service.getAllUsers()
                .stream()
                .map(u -> new UserResponseDTO(
                        u.getId(),
                        u.getEmail(),
                        u.getFirstName(),
                        u.getLastName(),
                        u.getRole()
                ))
                .toList();
    }

    // Get single user
    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        User u = service.getUserById(id);

        return new UserResponseDTO(
                u.getId(),
                u.getEmail(),
                u.getFirstName(),
                u.getLastName(),
                u.getRole()
        );
    }
}