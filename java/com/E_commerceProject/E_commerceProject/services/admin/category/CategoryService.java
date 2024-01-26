package com.E_commerceProject.E_commerceProject.services.admin.category;

import com.E_commerceProject.E_commerceProject.dto.CategoryDto;
import com.E_commerceProject.E_commerceProject.entity.Category;

import java.util.List;

public interface CategoryService {
    Category createcategory(CategoryDto categoryDto);
    List<Category> getAllCategories();
}
