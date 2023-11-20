package com.app.project.repository;

import com.app.project.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findCategoryByName(String name);



}
