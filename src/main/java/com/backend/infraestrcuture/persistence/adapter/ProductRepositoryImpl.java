package com.backend.infraestrcuture.persistence.adapter;

import com.backend.domain.model.Product;
import com.backend.domain.repository.ProductRepository;
import com.backend.infraestrcuture.persistence.entity.ProductEntity;
import com.backend.infraestrcuture.persistence.repository.JpaProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;

    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductEntity.fromDomain(product);
        return jpaProductRepository.save(entity).toDomain();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepository.findById(id).map(ProductEntity::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll()
                .stream()
                .map(ProductEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaProductRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaProductRepository.existsById(id);
    }
}
