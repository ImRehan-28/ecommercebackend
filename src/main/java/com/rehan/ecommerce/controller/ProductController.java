package com.rehan.ecommerce.controller;

import com.rehan.ecommerce.dto.request.ProductRequestDTO;
import com.rehan.ecommerce.dto.response.ProductResponseDTO;
import com.rehan.ecommerce.entities.Product;
import com.rehan.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.access.prepost.PreAuthorize;
@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Page<Product> getProducts(
            @RequestParam(required = false) String search,
            Pageable pageable
    ) {
        if (search != null && !search.isEmpty()) {
            return service.searchProducts(search, pageable);
        }
        return service.getAllProducts(pageable);
    }
    @PostMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponseDTO add(@RequestBody ProductRequestDTO request){
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setImage(request.getImage());
        Product saved = service.save(product);
        
        return toResponse(saved);
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/admin/bulk")
    @PreAuthorize("hasRole('ADMIN')")
    public List<ProductResponseDTO> addBulk(@RequestBody List<ProductRequestDTO> requests) {
        List<Product> products = requests.stream()
                .map(request -> {
                    Product product = new Product();
                    product.setName(request.getName());
                    product.setDescription(request.getDescription());
                    product.setPrice(request.getPrice());
                    product.setCategory(request.getCategory());
                    product.setImage(request.getImage());
                    return product;
                })
                .collect(Collectors.toList());

        return service.saveAll(products).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @PutMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponseDTO update(@PathVariable Long id, @RequestBody ProductRequestDTO p) {

        Product product = toEntity(p);
        product.setId(id);

        Product updated = service.save(product);

        return toResponse(updated);
    }

    @DeleteMapping("/admin/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private Product toEntity(ProductRequestDTO request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        return product;
    }

    private ProductResponseDTO toResponse(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
