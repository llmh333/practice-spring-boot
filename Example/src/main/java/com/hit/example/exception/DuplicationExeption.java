package com.hit.example.exception;

import com.hit.example.constant.ErrorCode;

public class DuplicationExeption extends RuntimeException {
    ErrorCode errorCode;
    public DuplicationExeption(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
