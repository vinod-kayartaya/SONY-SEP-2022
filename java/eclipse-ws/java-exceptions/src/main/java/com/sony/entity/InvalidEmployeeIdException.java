package com.sony.entity;

public class InvalidEmployeeIdException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidEmployeeIdException() {
	}

	public InvalidEmployeeIdException(String message) {
		super(message);
	}

	public InvalidEmployeeIdException(Throwable cause) {
		super(cause);
	}

}
