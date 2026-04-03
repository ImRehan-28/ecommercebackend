package com.rehan.ecommerce.dto.response;

public class UserResponseDTO {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String role;

    public UserResponseDTO(Long id, String email, String firstName, String lastName, String role) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }
// getters
}