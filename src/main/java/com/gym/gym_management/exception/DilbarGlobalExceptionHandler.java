package com.gym.gym_management.exception;

import com.gym.gym_management.dto.response.DilbarErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class DilbarGlobalExceptionHandler {

    @ExceptionHandler(DilbarNotFoundException.class)
    public ResponseEntity<DilbarErrorResponse> handleNotFound(DilbarNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new DilbarErrorResponse(404, ex.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DilbarErrorResponse> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new DilbarErrorResponse(400, message, LocalDateTime.now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<DilbarErrorResponse> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new DilbarErrorResponse(500, ex.getMessage(), LocalDateTime.now()));
    }
}
