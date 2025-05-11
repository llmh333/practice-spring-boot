package com.hit.example.exception;

import com.hit.example.domain.dto.response.ApiResponse;
import com.hit.example.util.ApiResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException e) {
        return ApiResponseUtil.error(e.errorCode);
    }

    @ExceptionHandler(DuplicationExeption.class)
    public ResponseEntity<?> handleDuplicationException(DuplicationExeption e) {
        return ApiResponseUtil.error(e.errorCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST)
                .field(e.getBindingResult().getFieldError().getField())
                .message(e.getBindingResult().getFieldError().getDefaultMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

}
