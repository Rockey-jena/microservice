package com.hotelService.exception;

import com.hotelService.payLoad.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHnadleException {
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException  resourceNotFoundException){
            String message = resourceNotFoundException.getMessage();
            ApiResponse res = ApiResponse.builder().message(message).sucess(true).status(HttpStatus.NOT_FOUND).build();
            return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
        }
    }

