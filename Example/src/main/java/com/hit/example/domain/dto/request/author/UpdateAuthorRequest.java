package com.hit.example.domain.dto.request.author;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateAuthorRequest {

    String name;
    LocalDate dob;
    String bio;
}
