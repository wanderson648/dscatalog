package com.devsuperior.auladev.entities.dto;

import com.devsuperior.auladev.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Long id;
    private String authority;

    public RoleDTO(Role role) {
        super();
        this.id = role.getId();
        this.authority = role.getAuthority();
    }
}
