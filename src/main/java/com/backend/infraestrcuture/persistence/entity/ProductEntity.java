package com.backend.infraestrcuture.persistence.entity;

import com.backend.domain.model.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime createdAt;

    public static ProductEntity fromDomain(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.id = product.getId();
        entity.name = product.getName();
        entity.description = product.getDescription();
        entity.price = product.getPrice();
        entity.stock = product.getStock();
        entity.createdAt = product.getCreatedAt();
        return entity;
    }

    public Product toDomain() {
        return new Product(id, name, description, price, stock, createdAt);
    }
}
