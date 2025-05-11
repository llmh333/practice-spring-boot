package com.hit.example.service;

import com.hit.example.domain.dto.request.book.CreateBookRequest;
import com.hit.example.domain.dto.request.book.UpdateBookRequest;
import com.hit.example.domain.dto.response.book.BookByIDResponse;
import com.hit.example.domain.dto.response.book.BookResponseDTO;

import java.util.List;

public interface BookService {

    public List<BookResponseDTO> getBooks();
    public BookByIDResponse getBookByID(Long idBook);
    public BookResponseDTO createBook(CreateBookRequest request);
    public BookResponseDTO updateBook(Long idBook, UpdateBookRequest request);
    public void deleteBookById(Long id);
}
