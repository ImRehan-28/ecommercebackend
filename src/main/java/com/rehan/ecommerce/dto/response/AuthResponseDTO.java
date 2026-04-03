package com.rehan.ecommerce.dto.response;

public class AuthResponseDTO {
    private String token;
    private String username;
    private String role;

    public AuthResponseDTO(String token, String username,String role) {
        this.token = token;
        this.username = username;
        this.role = role;
    }

    // getters

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {return role;}
}
