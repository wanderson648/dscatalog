package com.devsuperior.auladev.repositories;

import com.devsuperior.auladev.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
