package com.rehan.ecommerce.dto.response;

public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private double price;

    // constructor + getters

    public ProductResponseDTO(Long id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public ProductResponseDTO() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
