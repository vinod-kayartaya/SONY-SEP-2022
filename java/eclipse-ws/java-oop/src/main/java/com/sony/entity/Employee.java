package com.sony.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Employee implements Printable {

	private int id; // 4 bytes
	private String name; // 8 bytes
	private double salary; // 8 bytes
	
	public Employee(int id, String name) {
		this.setId(id); // avoid this.id = id;
		this.setName(name);
	}

	@Override
	public void print() {
		System.out.printf("ID             %s\n", id);
		System.out.printf("Name           %s\n", name);
		System.out.printf("Salary         Rs.%s\n", salary);
	}
	
	@Override
	public void printAsJson() {
		System.out.printf("{\n"
				+ "    \"id\": %d,\n"
				+ "    \"name\": \"%s\",\n"
				+ "    \"salary\": %f\n"
				+ "}", id, name, salary);
	}

}
