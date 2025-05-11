package com.hit.example.controller;


import com.hit.example.domain.dto.request.book.CreateBookRequest;
import com.hit.example.domain.dto.request.book.UpdateBookRequest;
import com.hit.example.domain.dto.response.book.BookByIDResponse;
import com.hit.example.domain.dto.response.book.BookResponseDTO;
import com.hit.example.service.BookService;
import com.hit.example.util.ApiResponseUtil;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookController {

    BookService bookService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<BookResponseDTO> bookResponseDTOList = bookService.getBooks();
        return ApiResponseUtil.succes(bookResponseDTOList, HttpStatus.OK);
    }

    @GetMapping("/get/{idBook}")
    public ResponseEntity<?> getBookById(@PathVariable Long idBook) {
        BookByIDResponse bookByIDResponse = bookService.getBookByID(idBook);
        return ApiResponseUtil.succes(bookByIDResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createBook(@RequestBody @Valid CreateBookRequest request) {
        BookResponseDTO bookResponseDTO = bookService.createBook(request);
        return ApiResponseUtil.succes(bookResponseDTO, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idBook}")
    public ResponseEntity<?> updateBook(@PathVariable Long idBook, @RequestBody @Valid UpdateBookRequest request) {
        BookResponseDTO bookResponseDTO = bookService.updateBook(idBook, request);
        return ApiResponseUtil.succes(bookResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idBook}")
    public ResponseEntity<?> deleteBook(@PathVariable Long idBook) {
        bookService.deleteBookById(idBook);
        return ApiResponseUtil.succes(null, HttpStatus.NO_CONTENT);
    }
}
