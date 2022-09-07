package com.sony.entity;

public class NameTooLongException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NameTooLongException() {
	}

	public NameTooLongException(String message) {
		super(message);
	}

	public NameTooLongException(Throwable cause) {
		super(cause);
	}

}
