package com.app.project.service;

import com.app.project.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);

    Category getCategoryById(Long categoryd);

    List<Category> getAllCategories();

    Category updateCategory(Category category);

    void deleteCategory(Long CategoryId);
}
