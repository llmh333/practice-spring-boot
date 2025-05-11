package com.hit.example.domain.dto.request.book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

@Data
public class CreateBookRequest {

    @NotNull
    String name;

    String description;

    @Min(0)
    double price;

    Long authorId;

    Long categoryId;
}
