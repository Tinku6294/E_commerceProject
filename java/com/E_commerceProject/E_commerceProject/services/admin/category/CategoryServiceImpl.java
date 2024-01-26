package com.E_commerceProject.E_commerceProject.services.admin.category;

import com.E_commerceProject.E_commerceProject.dto.CategoryDto;
import com.E_commerceProject.E_commerceProject.entity.Category;
import com.E_commerceProject.E_commerceProject.repsitory.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    public Category createcategory(CategoryDto categoryDto){
        Category category=new Category();
        category.setName(categoryDto.getName());
        category.setDescriprion(categoryDto.getDescription());
    return categoryRepository.save(category);
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

}
