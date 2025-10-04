package com.example.FitnessApp.service.impl;

import com.example.FitnessApp.dto.CategoryDto;
import com.example.FitnessApp.mapper.CategoryMapper;
import com.example.FitnessApp.model.Category;
import com.example.FitnessApp.repository.CategoryRepository;
import com.example.FitnessApp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAll() {
        return categoryMapper.toDtoList(categoryRepository.findAll());
    }

    @Override
    public CategoryDto getById(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).orElseThrow());
    }

    @Override
    public void addCategory(CategoryDto categoryDto) {
        categoryRepository.save(categoryMapper.toEntity(categoryDto));

    }

    @Override
    public void updateCategory(Long id, CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        category.setId(id);
        categoryRepository.save(category);

    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
