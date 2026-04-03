package com.rehan.ecommerce.service;

import com.rehan.ecommerce.entities.Product;
import com.rehan.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Product getById(Long id) {
        Optional<Product> product = repo.findById(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new RuntimeException("Product not found");
    }

    public Page<Product> searchProducts(String keyword, Pageable pageable) {
        return repo.searchByKeyword(keyword, pageable);
    }


    @Override
    public Product save(Product p) {
        return repo.save(p);
    }

    @Override
    public List<Product> saveAll(List<Product> products) {
        return repo.saveAll(products);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
