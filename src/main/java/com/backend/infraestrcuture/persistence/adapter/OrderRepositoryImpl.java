package com.backend.infraestrcuture.persistence.adapter;

import com.backend.domain.model.Order;
import com.backend.domain.model.OrderItem;
import com.backend.domain.repository.OrderRepository;
import com.backend.infraestrcuture.persistence.entity.OrderEntity;
import com.backend.infraestrcuture.persistence.entity.OrderItemEntity;
import com.backend.infraestrcuture.persistence.repository.JpaOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final JpaOrderRepository jpaOrderRepository;

    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository) {
        this.jpaOrderRepository = jpaOrderRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = toEntity(order);
        OrderEntity saved = jpaOrderRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return jpaOrderRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Order> findAll() {
        return jpaOrderRepository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private OrderEntity toEntity(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId());
        entity.setTotal(order.getTotal());
        entity.setCreatedAt(order.getCreatedAt());

        List<OrderItemEntity> items = order.getItems().stream().map(item -> {
            OrderItemEntity i = new OrderItemEntity();
            i.setProductId(item.getProductId());
            i.setProductName(item.getProductName());
            i.setUnitPrice(item.getUnitPrice());
            i.setQuantity(item.getQuantity());
            i.setOrder(entity);
            return i;
        }).collect(Collectors.toList());

        entity.setItems(items);
        return entity;
    }

    private Order toDomain(OrderEntity entity) {
        return new Order(
                entity.getId(),
                entity.getItems().stream().map(i ->
                        new OrderItem(
                                i.getProductId(),
                                i.getProductName(),
                                i.getUnitPrice(),
                                i.getQuantity()
                        )
                ).collect(Collectors.toList()),
                entity.getTotal(),
                entity.getCreatedAt());

    }
}
