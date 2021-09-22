package com.example.listingapp.service.impl;

import com.example.listingapp.entity.Category;
import com.example.listingapp.repository.CategoryRepository;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findCategoriesById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        categoryRepository.save(category);

        Optional<Category> byId = categoryRepository.findById(category.getId());

        if (byId.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        categoryRepository.save(category);

        return ResponseEntity
                .ok()
                .body(categoryRepository.save(category));


    }

    @Override
    public void deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
    }



}
