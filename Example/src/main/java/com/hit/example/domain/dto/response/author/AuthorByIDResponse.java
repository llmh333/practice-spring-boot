package com.hit.example.domain.dto.response.author;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorByIDResponse {
    String name;
    LocalDate dob;
    String bio;
    long quantityOfBooks;
}
