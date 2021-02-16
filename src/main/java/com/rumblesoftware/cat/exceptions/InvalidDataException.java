package com.rumblesoftware.cat.exceptions;

public class InvalidDataException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2641747536333521072L;

	private static final String DEFAULT_ERROR_MSG_CODE = "app.internal.error.message";
	
	public InvalidDataException() {
		super(DEFAULT_ERROR_MSG_CODE);
	}
}
