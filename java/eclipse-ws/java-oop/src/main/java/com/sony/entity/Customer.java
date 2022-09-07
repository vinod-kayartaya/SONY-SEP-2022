package com.sony.entity;

import lombok.Data;

@Data
public class Customer implements Printable {
	
	// When a class implements an interface, it is equivalent to 
	// a class extending another class with only abstract methods.
	// i.e, the class that implements the interface MUST override/implement all the methods defined
	// in the interface.
	
	// Also, an object of this class is an instance of Printable (i.e, the interfaces)
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private Address address = new Address(); // aggregation (HAS-A)
	
	@Override
	public void print() {
		System.out.printf("ID             %s\n", id);
		System.out.printf("Name           %s %s\n", firstname, lastname);
		System.out.printf("Email          %s\n", email);
		System.out.printf("Phone          %s\n", phone);
	}
}
