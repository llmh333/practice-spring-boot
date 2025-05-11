package com.hit.example.service.impl;

import com.hit.example.constant.ErrorCode;
import com.hit.example.domain.dto.request.author.CreateAuthorRequest;
import com.hit.example.domain.dto.request.author.UpdateAuthorRequest;
import com.hit.example.domain.dto.response.author.AuthorByIDResponse;
import com.hit.example.domain.dto.response.author.AuthorResponseDTO;
import com.hit.example.domain.mapper.AuthorMapper;
import com.hit.example.domain.model.Author;
import com.hit.example.exception.NotFoundException;
import com.hit.example.repository.AuthorRepository;
import com.hit.example.service.AuthorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;
    AuthorMapper authorMapper;

    @Override
    public List<AuthorResponseDTO> getAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorResponseDTO> authorResponseDTOS = new ArrayList<>();
        for (Author author : authors) {
            authorResponseDTOS.add(authorMapper.toAuthorResponseDTO(author));
        }
        return authorResponseDTOS;
    }

    @Override
    public AuthorByIDResponse getAuthorById(Long idAuthor) {
        Author author = authorRepository.findById(idAuthor).orElseThrow(() -> new NotFoundException(ErrorCode.AUTHOR_NOT_FOUND));
        AuthorByIDResponse authorByIDResponse = authorMapper.toAuthorByIDResponse(author);
        authorByIDResponse.setQuantityOfBooks(author.getBooks().size());
        return authorByIDResponse;

    }

    @Override
    public AuthorResponseDTO createAuthor(CreateAuthorRequest request) {
        Author newAuthor = authorMapper.toAuthor(request);
        return authorMapper.toAuthorResponseDTO(authorRepository.save(newAuthor));
    }

    @Override
    public AuthorResponseDTO updateAuthor(Long idAuthor, UpdateAuthorRequest request) {
        Author author = authorRepository.findById(idAuthor).orElseThrow(() -> new NotFoundException(ErrorCode.AUTHOR_NOT_FOUND));
        if (request.getName() != null) {
            author.setName(request.getName());
        }
        if (request.getDob() != null) {
            author.setDob(request.getDob());
        }
        if (request.getBio() != null) {
            author.setBio(request.getBio());
        }
        return authorMapper.toAuthorResponseDTO(authorRepository.save(author));
    }

    @Override
    public void deleteAuthorById(Long idAuthor) {
        if (authorRepository.existsById(idAuthor)) {
            authorRepository.deleteById(idAuthor);
        } else {
            throw new NotFoundException(ErrorCode.AUTHOR_NOT_FOUND);
        }
    }
}
