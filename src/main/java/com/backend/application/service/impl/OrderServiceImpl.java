package com.backend.application.service.impl;

import com.backend.application.service.OrderService;
import com.backend.domain.model.Order;
import com.backend.domain.repository.OrderRepository;
import com.backend.infraestrcuture.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(Order order) {
        order.recalculateTotal();
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", id));
    }


    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
