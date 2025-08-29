package com.devsuperior.auladev.entities.dto;

import com.devsuperior.auladev.entities.Category;

import java.time.LocalDateTime;

public record CategoryResponseDTO(
        Long id,
        String name,
        LocalDateTime createdAt
) {
    public CategoryResponseDTO(Category category) {
        this(category.getId(), category.getName(), category.getCreatedAt());
    }
}
