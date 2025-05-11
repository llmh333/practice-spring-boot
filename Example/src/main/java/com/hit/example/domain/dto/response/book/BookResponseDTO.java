package com.hit.example.domain.dto.response.book;

import com.hit.example.domain.dto.response.author.AuthorResponseDTO;
import com.hit.example.domain.dto.response.category.CategoryResponseDTO;
import lombok.Data;

@Data
public class BookResponseDTO {
    Long id;
    String name;
    String description;
    double price;
    AuthorResponseDTO author;
    CategoryResponseDTO category;

}
