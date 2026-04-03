package com.rehan.ecommerce.service;

import com.rehan.ecommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    public Page<Product> getAllProducts(Pageable pageable);

    public Product getById(Long id);

    public Product save(Product p);

    public List<Product> saveAll(List<Product> products);

    public void delete(Long id);

    public Page<Product> searchProducts(String keyword, Pageable pageable);
}
