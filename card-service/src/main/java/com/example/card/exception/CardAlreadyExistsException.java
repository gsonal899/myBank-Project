package com.example.card.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardAlreadyExistsException(String resourceName, String fieldName, String fieldValue) {
    	super(String.format("%s already exists with given %s : '%s'", resourceName, fieldName, fieldValue));
    }

}
