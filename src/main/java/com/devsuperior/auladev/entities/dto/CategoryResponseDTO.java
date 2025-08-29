package com.devsuperior.auladev.entities.dto;

import com.devsuperior.auladev.entities.Category;

public record CategoryResponseDTO(
        Long id,
        String name
) {
    public CategoryResponseDTO(Category category) {
        this(category.getId(), category.getName());
    }
}
