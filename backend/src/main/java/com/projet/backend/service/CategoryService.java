package com.projet.backend.service;

import com.projet.backend.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Category saveCategory(Category category);
    public Optional<Category> getCategoryById(Long id);
    public void deleteCategoryById(Long id);
    public Category updateCategory(Long id, Category newCategory);
    public List<Category> getAllCategory();

}
