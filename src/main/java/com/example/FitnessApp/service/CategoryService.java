package com.example.FitnessApp.service;

import com.example.FitnessApp.dto.CategoryDto;
import com.example.FitnessApp.model.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
    void addCategory(CategoryDto categoryDto);
    void updateCategory(Long id, CategoryDto categoryDto);
    void deleteCategory(Long id);
}
