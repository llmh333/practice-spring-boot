package com.hit.example.domain.mapper;

import com.hit.example.domain.dto.request.author.CreateAuthorRequest;
import com.hit.example.domain.dto.request.author.UpdateAuthorRequest;
import com.hit.example.domain.dto.response.author.AuthorByIDResponse;
import com.hit.example.domain.dto.response.author.AuthorResponseDTO;
import com.hit.example.domain.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorResponseDTO toAuthorResponseDTO(Author author);
    AuthorByIDResponse toAuthorByIDResponse(Author author);
    Author toAuthor(CreateAuthorRequest createAuthorRequest);
    Author toAuthor(UpdateAuthorRequest updateAuthorRequest);
}
