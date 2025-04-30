package com.backend.infraestrcuture.persistence.repository;

import com.backend.infraestrcuture.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {

}
