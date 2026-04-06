package com.rehan.ecommerce.dto.response;

public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String image;

    // constructor + getters

    public ProductResponseDTO(Long id, String name, String description, double price, String category, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
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

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }
}
