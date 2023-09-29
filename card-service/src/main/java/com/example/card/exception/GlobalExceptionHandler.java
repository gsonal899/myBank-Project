package com.example.card.exception;


import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler
{
    

    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCardNotFoundException(CardNotFoundException exception,
                                                                                 WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                webRequest.getDescription(true)
               
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CardAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleCardAlreadyExistsException(CardAlreadyExistsException exception,
                                                                                 WebRequest webRequest){
    	ErrorResponse errorResponse = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                webRequest.getDescription(true)
               
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception exception,
                                                                            WebRequest webRequest) {
    	ErrorResponse errorResponse = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                webRequest.getDescription(true)
               
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
