package com.devsuperior.auladev.entities.dto;

import com.devsuperior.auladev.entities.Role;

public record RoleDTO(
        Long id,
        String authority
) {

    public RoleDTO(Role role) {
        this(role.getId(), role.getAuthority());
    }
}
