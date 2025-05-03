package com.backend.application.service;

import com.backend.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();
}

