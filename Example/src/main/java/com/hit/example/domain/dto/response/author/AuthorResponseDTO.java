package com.hit.example.domain.dto.response.author;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hit.example.domain.model.Author;
import com.hit.example.domain.model.Category;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorResponseDTO {
    String name;
    LocalDate dob;
    String bio;
}
