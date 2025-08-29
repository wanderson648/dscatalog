package com.devsuperior.auladev.service;

import com.devsuperior.auladev.entities.dto.CategoryListDTO;
import com.devsuperior.auladev.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryListDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(cat -> new CategoryListDTO(cat.getId(),
                                cat.getName(), cat.getCreatedAt())).toList();
    }
}
