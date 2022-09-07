package com.sony.entity;

import lombok.Data;

@Data
public class Student extends Person {
	// Student is a subclass of Person
	// Person is the superclass for Student

	private double gpa;
	private String majorSubject;
	private double semister;

	@Override
	public String toString() {
		return "Student [gpa=" + gpa + ", majorSubject=" + majorSubject + ", semister=" + semister + ", Person="
				+ super.toString() + "]";
	}

}
