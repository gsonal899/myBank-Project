package com.example.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountAlreadyExistsException(String resourceName, String fieldName, String fieldValue) 
    {
    	super(String.format("%s already exists with  %s : '%s'", resourceName, fieldName, fieldValue));
    
    }

}
