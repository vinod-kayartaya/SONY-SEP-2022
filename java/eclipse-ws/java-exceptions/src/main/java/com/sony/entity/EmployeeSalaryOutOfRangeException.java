package com.sony.entity;

public class EmployeeSalaryOutOfRangeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeSalaryOutOfRangeException() {
	}

	public EmployeeSalaryOutOfRangeException(String message) {
		super(message);
	}

	public EmployeeSalaryOutOfRangeException(Throwable cause) {
		super(cause);
	}

}
