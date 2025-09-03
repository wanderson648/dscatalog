package com.devsuperior.auladev.repositories;

import com.devsuperior.auladev.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
