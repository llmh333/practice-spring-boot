package com.hit.example.controller;

import com.hit.example.domain.dto.request.author.CreateAuthorRequest;
import com.hit.example.domain.dto.request.author.UpdateAuthorRequest;
import com.hit.example.domain.dto.response.author.AuthorByIDResponse;
import com.hit.example.domain.dto.response.author.AuthorResponseDTO;
import com.hit.example.service.AuthorService;
import com.hit.example.util.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/author")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorController {

    AuthorService authorService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAuthors() {
        List<AuthorResponseDTO> authorResponseDTOList = authorService.getAuthors();
        return ApiResponseUtil.succes(authorResponseDTOList, HttpStatus.OK);
    }

    @GetMapping("/get/{idAuthor}")
    public ResponseEntity<?> getAuthorById(@PathVariable Long idAuthor) {
        AuthorByIDResponse authorByIDResponse = authorService.getAuthorById(idAuthor);
        return ApiResponseUtil.succes(authorByIDResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createAuthor(@RequestBody @Valid CreateAuthorRequest request) {
        AuthorResponseDTO authorResponseDTO = authorService.createAuthor(request);
        return ApiResponseUtil.succes(authorResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idAuthor}")
    public ResponseEntity<?> updateAuthor(@PathVariable Long idAuthor, @RequestBody @Valid UpdateAuthorRequest request) {
        AuthorResponseDTO authorResponseDTO = authorService.updateAuthor(idAuthor, request);
        return ApiResponseUtil.succes(authorResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idAuthor}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long idAuthor) {
        authorService.deleteAuthorById(idAuthor);
        return ApiResponseUtil.succes(null, HttpStatus.NO_CONTENT);
    }
}
