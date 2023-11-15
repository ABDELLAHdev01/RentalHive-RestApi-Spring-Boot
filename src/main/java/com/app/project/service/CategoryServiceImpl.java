package com.app.project.service;

import com.app.project.model.Category;
import com.app.project.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategoryById(Long categoryId){
        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);
        return optionalCategory.get();
    }
    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).get();
        existingCategory.setName(category.getName());
        Category updatedCategory= categoryRepository.save(existingCategory);
        return updatedCategory;
    }

    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }

}
