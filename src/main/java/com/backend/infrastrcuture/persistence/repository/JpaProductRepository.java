package com.backend.infrastrcuture.persistence.repository;

import com.backend.infrastrcuture.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

}
