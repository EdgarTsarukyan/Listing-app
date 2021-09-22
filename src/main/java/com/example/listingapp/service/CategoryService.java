package com.example.listingapp.service;

import com.example.listingapp.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAllCategories();

    Optional<Category> findCategoriesById(int id);

    ResponseEntity<Category> addCategory(Category category);
    void deleteCategoryById(int id);



}
