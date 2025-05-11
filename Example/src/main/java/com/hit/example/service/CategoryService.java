package com.hit.example.service;

import com.hit.example.domain.dto.request.category.CreateCategoryRequest;
import com.hit.example.domain.dto.response.category.CategoryByIDResponse;
import com.hit.example.domain.dto.response.category.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {

    public List<CategoryResponseDTO> getCategories();
    public CategoryByIDResponse getCategoryByID(Long idCategory);
    public CategoryResponseDTO createCategory(CreateCategoryRequest request);
    public void deleteCategoryById(Long id);
}
