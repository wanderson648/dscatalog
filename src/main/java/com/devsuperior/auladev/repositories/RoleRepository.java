package com.devsuperior.auladev.repositories;

import com.devsuperior.auladev.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
