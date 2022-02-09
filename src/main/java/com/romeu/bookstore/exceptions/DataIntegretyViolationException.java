package com.romeu.bookstore.exceptions;

public class DataIntegretyViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegretyViolationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataIntegretyViolationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
