package com.example.account.exception;


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
    

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException exception,
                                                                                 WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse(
        		LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                webRequest.getDescription(true)
               
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleAccountAlreadyExistsException(AccountAlreadyExistsException exception,
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
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                webRequest.getDescription(true)
               
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
