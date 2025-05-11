package com.hit.example.domain.mapper;

import com.hit.example.domain.dto.request.book.CreateBookRequest;
import com.hit.example.domain.dto.request.book.UpdateBookRequest;
import com.hit.example.domain.dto.response.book.BookByIDResponse;
import com.hit.example.domain.dto.response.book.BookResponseDTO;
import com.hit.example.domain.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponseDTO toBookResponseDTO(Book book);
    BookByIDResponse toBookByIDResponse(Book book);
    Book toBook(CreateBookRequest createBookRequest);
    Book toBook(UpdateBookRequest updateBookRequest);

}
