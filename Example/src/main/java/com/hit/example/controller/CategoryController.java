package com.hit.example.controller;

import com.hit.example.domain.dto.request.category.CreateCategoryRequest;
import com.hit.example.domain.dto.response.category.CategoryByIDResponse;
import com.hit.example.domain.dto.response.category.CategoryResponseDTO;
import com.hit.example.service.CategoryService;
import com.hit.example.util.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {

    CategoryService categoryService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getCategories() {
        List<CategoryResponseDTO> categoryResponseDTOList = categoryService.getCategories();
        return ApiResponseUtil.succes(categoryResponseDTOList, HttpStatus.OK);
    }

    @GetMapping("/get/{idCategory}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long idCategory) {
        CategoryByIDResponse categoryByIDResponse = categoryService.getCategoryByID(idCategory);
        return ApiResponseUtil.succes(categoryByIDResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createCategory(@RequestBody @Valid CreateCategoryRequest createCategoryRequest) {
        categoryService.createCategory(createCategoryRequest);
        return ApiResponseUtil.succes(createCategoryRequest, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idCategory}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long idCategory) {
        categoryService.deleteCategoryById(idCategory);
        return ApiResponseUtil.succes(null, HttpStatus.NO_CONTENT);
    }

}
