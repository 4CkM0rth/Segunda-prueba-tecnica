package com.backend.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


public class Product {


    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime createdAt;

    public Product(Long id, String name, String description, BigDecimal price, Integer stock, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        this.stock -= quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id);
    }

    public int HashCode() {
        return Objects.hash(id);
    }
}
