package com.hit.example.domain.dto.response.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryByIDResponse {
    Long id;
    String name;
    long quantityOfBooks;
}
