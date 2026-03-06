package com.projet.backend.service;

import com.projet.backend.model.Category;
import com.projet.backend.repository.CategoryRepository;
import com.projet.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository){
        this.repository=repository;
    }

    /** 
     * @param category
     * @return Category
     */
    @Override
    public Category saveCategory(Category category) {

        return repository.save(category);
    }

    /** 
     * @param id
     * @return Optional<Category>
     */
    @Override
    public Optional<Category> getCategoryById(Long id) {
        return repository.findById(id);
    }

    /** 
     * @param id
     */
    @Override
    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }

    /** 
     * @param id
     * @param newCategory
     * @return Category
     */
    @Override
    public Category updateCategory(Long id, Category newCategory) {
        return repository.findById(id)
                .map(category -> {
                    category.setName(newCategory.getName());
                    return repository.save(category);
                }).orElse(null);
    }

    /** 
     * @return List<Category>
     */
    @Override
    public List<Category> getAllCategory() {
        return repository.findAll();
    }
}
