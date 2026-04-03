package com.rehan.ecommerce.dto.request;
//it is for login too

public class AuthRequestDTO {

    private String email;

    private String password;

    private String role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole(String role) {return role;}
// getters & setters
}