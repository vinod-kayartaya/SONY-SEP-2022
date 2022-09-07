package com.sony.entity;

public class NullNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NullNameException() {
	}

	public NullNameException(String message) {
		super(message);
	}

	public NullNameException(Throwable cause) {
		super(cause);
	}

}
