package com.sony.utils;

public class MathsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MathsException() {
		super();
	}

	public MathsException(String message) {
		super(message);
	}

	public MathsException(Throwable cause) {
		super(cause);
	}

}
