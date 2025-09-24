package com.devsuperior.auladev.entities.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(
        Long id,
        @NotBlank(message = "Campo obrigatório")
        String name
) {
}
