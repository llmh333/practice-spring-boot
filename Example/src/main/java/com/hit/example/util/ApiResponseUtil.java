package com.hit.example.util;


import com.hit.example.constant.ErrorCode;
import com.hit.example.domain.dto.response.ApiResponse;
import com.hit.example.constant.StatusMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ApiResponseUtil {
    public static ResponseEntity<ApiResponse> succes(Object data, HttpStatus status) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(status.value())
                .status(status)
                .message(StatusMessage.SUCCESS.name())
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, status);
    }

    public static ResponseEntity<ApiResponse> error(ErrorCode errorCode) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(errorCode.getStatus().value())
                .status(errorCode.getStatus())
                .message(errorCode.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, errorCode.getStatus());
    }
}
