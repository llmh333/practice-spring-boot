package com.hit.example.domain.mapper;

import com.hit.example.domain.dto.request.category.CreateCategoryRequest;
import com.hit.example.domain.dto.response.category.CategoryByIDResponse;
import com.hit.example.domain.dto.response.category.CategoryResponseDTO;
import com.hit.example.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponseDTO toCategoryResponseDTO(Category category);
    CategoryByIDResponse toCategoryByIDResponse(Category category);
    Category toCategory(CreateCategoryRequest createCategoryRequest);
}
