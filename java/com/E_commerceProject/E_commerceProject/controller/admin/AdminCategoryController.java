package com.E_commerceProject.E_commerceProject.controller.admin;

import com.E_commerceProject.E_commerceProject.dto.CategoryDto;
import com.E_commerceProject.E_commerceProject.entity.Category;
import com.E_commerceProject.E_commerceProject.services.admin.category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AdminCategoryController {

private final CategoryService categoryService;

    public AdminCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
@PostMapping("category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
    Category category= categoryService.createcategory(categoryDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(category);
}
@GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
