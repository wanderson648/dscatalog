package com.devsuperior.auladev.service;

import com.devsuperior.auladev.entities.Role;
import com.devsuperior.auladev.entities.User;
import com.devsuperior.auladev.entities.dto.UserDTO;
import com.devsuperior.auladev.exception.DatabaseException;
import com.devsuperior.auladev.exception.ResourceNotFoundException;
import com.devsuperior.auladev.repositories.RoleRepository;
import com.devsuperior.auladev.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Page<UserDTO> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(UserDTO::new);
    }


    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        if (obj.isEmpty()) {
            throw new ResourceNotFoundException("Usuário não encontrada");
        }
        User user = obj.get();
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO insert(UserDTO dto) {
        User user = new User(dto);
        userRepository.save(user);
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        try {
            User user = userRepository.getReferenceById(id);
            Role role = roleRepository.getReferenceById(user.getId());

            user.update(dto, role);
            return new UserDTO(user);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("id não encontrada: " + id);
        }
    }

    public void delete(Long id) {
        if(!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
