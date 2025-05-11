package com.hit.example.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    BOOK_NAME_ALREADY_EXIST(HttpStatus.CONFLICT, ErrorMessage.BOOK_NAME_ALREADY_EXISTS),
    BOOK_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorMessage.BOOK_NOT_FOUND),
    AUTHOR_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorMessage.AUTHOR_NOT_FOUND),
    CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, ErrorMessage.CATEGORY_NOT_FOUND);


    HttpStatus status;
    final String message;

}
