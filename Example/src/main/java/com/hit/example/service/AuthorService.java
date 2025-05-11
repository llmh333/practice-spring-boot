package com.hit.example.service;

import com.hit.example.domain.dto.request.author.CreateAuthorRequest;
import com.hit.example.domain.dto.request.author.UpdateAuthorRequest;
import com.hit.example.domain.dto.response.author.AuthorByIDResponse;
import com.hit.example.domain.dto.response.author.AuthorResponseDTO;

import java.util.List;
import java.util.Map;

public interface AuthorService {

    public List<AuthorResponseDTO> getAuthors();
    public AuthorByIDResponse getAuthorById(Long  idAuthor);
    public AuthorResponseDTO createAuthor(CreateAuthorRequest request);
    public AuthorResponseDTO updateAuthor(Long idAuthor, UpdateAuthorRequest request);
    public void deleteAuthorById(Long idAuthor);
}
