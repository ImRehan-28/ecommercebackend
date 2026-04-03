package com.rehan.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
@Table
    public class User {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;

    private String email;
    private String firstName;
    private String lastName;
        private String password;
        private String role; // ROLE_USER, ROLE_ADMIN
    }