package com.epam.labs.controller;

import com.epam.labs.error.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(BindException.class)
    public final ResponseEntity<Object> handleBindExceptions(Exception ex, WebRequest request) {
        String details = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("error code =" + BAD_REQUEST, details);
        return new ResponseEntity<>(errorResponse, BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
        String details = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("error code =" + INTERNAL_SERVER_ERROR, details);
        return new ResponseEntity<>(errorResponse, INTERNAL_SERVER_ERROR);
    }
}
