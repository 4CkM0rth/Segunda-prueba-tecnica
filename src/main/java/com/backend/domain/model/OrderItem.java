package com.backend.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderItem {

    private Long productId;
    private String productName;
    private BigDecimal unitPrice;
    private int quantity;

    public OrderItem(Long productId, String productName, BigDecimal unitPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getSubTotal() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem item)) return false;
        return Objects.equals(productId, item.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }


}
