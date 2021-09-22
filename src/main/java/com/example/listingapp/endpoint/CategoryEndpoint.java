package com.example.listingapp.endpoint;

import com.example.listingapp.entity.Category;
import com.example.listingapp.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryEndpoint {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> categories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategories(@PathVariable("id") int id) {
        Optional<Category> byId = categoryService.findCategoriesById(id);

        if (byId.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        return ResponseEntity.ok(byId.get());
    }



    @PostMapping
    public ResponseEntity<Category> category(@RequestBody Category category) {
    return   categoryService.addCategory(category);

    }

    @PutMapping
    public ResponseEntity<Category> category1(@RequestBody Category category) {


       return categoryService.addCategory(category);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") int id) {
        Optional<Category> byId = categoryService.findCategoriesById(id);

        if (byId.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        }
        categoryService.deleteCategoryById(id);
        return ResponseEntity
                .noContent()
                .build();
    }
}
