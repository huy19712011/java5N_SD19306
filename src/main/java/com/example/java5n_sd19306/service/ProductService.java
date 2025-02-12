package com.example.java5n_sd19306.service;

import com.example.java5n_sd19306.entity.Product;
import com.example.java5n_sd19306.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public void saveProduct(@Valid Product product) {

        productRepository.save(product);
    }

    public void deleteProductById(long id) {

        productRepository.deleteById(id);
    }

    public Product getProductById(long id) {

        return productRepository.findById(id).get();
    }

    public void updateProduct(@Valid Product product) {

        productRepository.save(product);
    }
}
