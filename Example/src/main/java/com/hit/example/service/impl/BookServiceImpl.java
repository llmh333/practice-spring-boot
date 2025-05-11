package com.hit.example.service.impl;

import com.hit.example.constant.ErrorCode;
import com.hit.example.domain.dto.request.book.CreateBookRequest;
import com.hit.example.domain.dto.request.book.UpdateBookRequest;
import com.hit.example.domain.dto.response.book.BookByIDResponse;
import com.hit.example.domain.dto.response.book.BookResponseDTO;
import com.hit.example.domain.mapper.AuthorMapper;
import com.hit.example.domain.mapper.BookMapper;
import com.hit.example.domain.mapper.CategoryMapper;
import com.hit.example.domain.model.Author;
import com.hit.example.domain.model.Book;
import com.hit.example.domain.model.Category;
import com.hit.example.exception.DuplicationExeption;
import com.hit.example.exception.NotFoundException;
import com.hit.example.repository.AuthorRepository;
import com.hit.example.repository.BookRepository;
import com.hit.example.repository.CategoryRepository;
import com.hit.example.service.BookService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    AuthorRepository authorRepository;
    CategoryRepository categoryRepository;
    BookMapper bookMapper;
    AuthorMapper authorMapper;
    CategoryMapper categoryMapper;

    @Override
    public List<BookResponseDTO> getBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseDTO> bookResponseDTOList = new ArrayList<>();
        for (Book book : books) {
            BookResponseDTO bookResponseDTO = bookMapper.toBookResponseDTO(book);
            bookResponseDTO.setAuthor(authorMapper.toAuthorResponseDTO(book.getAuthor()));
            bookResponseDTO.setCategory(categoryMapper.toCategoryResponseDTO(book.getCategory()));
            bookResponseDTOList.add(bookResponseDTO);
        }
        return bookResponseDTOList;
    }

    @Override
    public BookByIDResponse getBookByID(Long idBook) {
        Book book = bookRepository.findById(idBook).orElseThrow(() -> new NotFoundException(ErrorCode.BOOK_NOT_FOUND));
        BookByIDResponse bookByIDResponse = bookMapper.toBookByIDResponse(book);
        bookByIDResponse.setAuthorName(book.getAuthor().getName());
        bookByIDResponse.setCategoryName(book.getCategory().getName());
        return bookByIDResponse;
    }

    @Override
    public BookResponseDTO createBook(CreateBookRequest request) {
        Book book = bookMapper.toBook(request);
        if (request.getAuthorId() != null) {
            Author author = authorRepository.findById(request.getAuthorId()).orElseThrow(() -> new NotFoundException(ErrorCode.AUTHOR_NOT_FOUND));
            book.setAuthor(author);
        }
        if (request.getCategoryId() != null) {
            Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND));
            book.setCategory(category);
        }
        return bookMapper.toBookResponseDTO(bookRepository.save(book));
    }

    @Override
    public BookResponseDTO updateBook(Long idBook, UpdateBookRequest request) {
        if (bookRepository.existsById(idBook)) {
            throw new NotFoundException(ErrorCode.BOOK_NOT_FOUND);
        }
        Book book = bookMapper.toBook(request);
        if (request.getName() != null) {
            if (bookRepository.existsByName(request.getName())) {
                throw new DuplicationExeption(ErrorCode.BOOK_NAME_ALREADY_EXIST);
            }
            book.setName(request.getName());
        }
        if (request.getDescription() != null) {
            book.setDescription(request.getDescription());
        }
        if (request.getCategoryId() != null) {
            Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new NotFoundException(ErrorCode.CATEGORY_NOT_FOUND));
            book.setCategory(category);
        }
        if (request.getPrice() > 0) {
            book.setPrice(request.getPrice());
        }
        return bookMapper.toBookResponseDTO(bookRepository.save(book));
    }

    @Override
    public void deleteBookById(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new NotFoundException(ErrorCode.BOOK_NOT_FOUND);
        }
    }
}
