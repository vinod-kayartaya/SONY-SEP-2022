package com.sony.entity;

import lombok.Data;

@Data
public class Person {
	private String firstname;
	private String lastname;
	private int age;
	private double height;
	private double weight;
	
	private Address address = new Address();
}
