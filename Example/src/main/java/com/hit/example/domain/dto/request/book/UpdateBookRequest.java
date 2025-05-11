package com.hit.example.domain.dto.request.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateBookRequest {
    String name;
    String description;
    @Min(0)
    double price;
    Long categoryId;
}
