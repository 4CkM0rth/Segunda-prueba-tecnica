package com.backend.infraestrcuture.controller;

import com.backend.application.service.ProductService;
import com.backend.domain.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product create = productService.createProduct(product);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct (@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        Product update = productService.updateProduct(product);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping
    public ResponseEntity<Product> deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
