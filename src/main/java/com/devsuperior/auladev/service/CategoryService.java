package com.devsuperior.auladev.service;

import com.devsuperior.auladev.entities.Category;
import com.devsuperior.auladev.entities.dto.CategoryListDTO;
import com.devsuperior.auladev.entities.dto.CategoryRequestDTO;
import com.devsuperior.auladev.entities.dto.CategoryResponseDTO;
import com.devsuperior.auladev.exception.EntityNotFoundException;
import com.devsuperior.auladev.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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


    @Transactional(readOnly = true)
    public CategoryResponseDTO findById(Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        if (obj.isEmpty()) {
            throw new EntityNotFoundException("Category not found");
        }
        Category category = obj.get();
        return new CategoryResponseDTO(category);
    }

    @Transactional
    public CategoryResponseDTO insert(CategoryRequestDTO dto) {
        Category category = new Category(dto);
        categoryRepository.save(category);
        return new CategoryResponseDTO(category);
    }
}
