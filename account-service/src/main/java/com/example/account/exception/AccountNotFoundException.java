package com.example.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String resourceName, String fieldName, int fieldValue) {
        super(String.format("%s not found with the given  %s : '%s'", resourceName, fieldName, fieldValue));
    }

}
