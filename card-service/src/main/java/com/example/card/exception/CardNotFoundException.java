package com.example.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CardNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardNotFoundException(String resourceName, String fieldName, String fieldValue) 
    {
        super(String.format("%s not found with given %s : '%s'", resourceName, fieldName, fieldValue));
    }

}
