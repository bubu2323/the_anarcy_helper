package com.example.the_anarchy_helper.exceptions;

import com.example.the_anarchy_helper.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<List<ErrorResponse>> handleValidationException(MethodArgumentNotValidException ex) {
        List<ErrorResponse> errorList = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> ErrorResponse.builder()
                        .field(error.getField())
                        .message(error.getDefaultMessage())
                        .build())
                .toList();
        return ResponseEntity.badRequest().body(errorList);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNotSuchElementException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().message(ex.getMessage()).build());
    }
}
