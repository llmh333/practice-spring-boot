package com.hit.example.exception;

import com.hit.example.constant.ErrorCode;

public class NotFoundException extends RuntimeException {

    ErrorCode errorCode;
    public NotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
