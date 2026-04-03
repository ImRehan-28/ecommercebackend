package com.rehan.ecommerce.dto.response;

public class OrderResponseDTO {
    private Long id;
    private String status;

    // constructor + getters

    public OrderResponseDTO(Long id, String status) {
        this.id = id;
        this.status = status;
    }
    public OrderResponseDTO() {}


    public String getStatus() {
        return status;
    }
}
