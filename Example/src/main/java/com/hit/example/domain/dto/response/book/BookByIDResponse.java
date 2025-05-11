package com.hit.example.domain.dto.response.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hit.example.domain.model.Author;
import com.hit.example.domain.model.Category;
import lombok.Data;

@Data
public class BookByIDResponse {
    Long id;
    String name;
    String description;
    double price;
    String authorName;
    String categoryName;
}
