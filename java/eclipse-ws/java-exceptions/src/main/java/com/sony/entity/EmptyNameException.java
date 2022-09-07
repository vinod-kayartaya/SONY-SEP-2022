package com.sony.entity;

public class EmptyNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyNameException() {
	}

	public EmptyNameException(String message) {
		super(message);
	}

	public EmptyNameException(Throwable cause) {
		super(cause);
	}

	
}
