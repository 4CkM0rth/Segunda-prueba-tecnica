package com.backend.application.service;

import com.backend.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    void deleteProduct(Long id);
}

