package com.devsuperior.auladev.entities.dto;

import java.time.LocalDateTime;

public record CategoryListDTO(
        Long id,
        String name,
        LocalDateTime createdAt
) {
}
