package com.example.balance.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerIdNotPresentException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomerIdNotPresentException(String resourceName, String fieldName, Long fieldValue)
	{
		super(String.format("%s not found with given %s : '%s'", resourceName, fieldName, fieldValue));
	}

}
