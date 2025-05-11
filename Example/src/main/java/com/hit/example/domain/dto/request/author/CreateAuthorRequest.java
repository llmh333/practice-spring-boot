package com.hit.example.domain.dto.request.author;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateAuthorRequest {

    @NotNull
    String name;
    @NotNull
    LocalDate dob;

    String bio;
}
