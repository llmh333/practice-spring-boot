package com.hit.example.service.impl;

import com.hit.example.constant.ErrorCode;
import com.hit.example.domain.dto.request.category.CreateCategoryRequest;
import com.hit.example.domain.dto.response.category.CategoryByIDResponse;
import com.hit.example.domain.dto.response.category.CategoryResponseDTO;
import com.hit.example.domain.mapper.CategoryMapper;
import com.hit.example.domain.model.Category;
import com.hit.example.exception.NotFoundException;
import com.hit.example.repository.CategoryRepository;
import com.hit.example.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;


    @Override
    public List<CategoryResponseDTO> getCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoriesResponseDTO = new ArrayList<>();
        for (Category category : categories) {
            categoriesResponseDTO.add(categoryMapper.toCategoryResponseDTO(category));
        }
        return categoriesResponseDTO;
    }

    @Override
    public CategoryByIDResponse getCategoryByID(Long idCategory) {
        Category category = categoryRepository.findById(idCategory).orElseThrow(() -> new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND));
        CategoryByIDResponse categoryByIDResponse = categoryMapper.toCategoryByIDResponse(category);
        categoryByIDResponse.setQuantityOfBooks(category.getBooks().size());
        return categoryByIDResponse;
    }

    @Override
    public CategoryResponseDTO createCategory(CreateCategoryRequest request) {
        Category category = categoryMapper.toCategory(request);
        if (request.getName() != null) {
            category.setName(request.getName());
        }
        return categoryMapper.toCategoryResponseDTO(categoryRepository.save(category));
    }

    @Override
    public void deleteCategoryById(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND);
        }
    }
}
