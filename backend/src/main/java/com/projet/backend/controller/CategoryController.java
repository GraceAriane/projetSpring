package com.projet.backend.controller;


import com.projet.backend.model.Category;
import com.projet.backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping
    public List<Category> getAllCategory() {
        return service.getAllCategory();
    }

    @GetMapping("/{id}")
    public Optional<Category> geCategoryId(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @PostMapping
    public Category create(@RequestBody Category category) {
        return service.saveCategory(category);
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return service.saveCategory(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteCategoryById(id);
    }
}