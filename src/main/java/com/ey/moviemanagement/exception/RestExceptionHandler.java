package com.ey.moviemanagement.exception;

import com.ey.moviemanagement.config.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    protected ResponseEntity<Object> handleMovieNotFound(MovieNotFoundException ex) {
        ApiError apiError=ApiError.builder().status(HttpStatus.NOT_FOUND)
                .exceptionMessage(ex.getMessage())
                .build();
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
