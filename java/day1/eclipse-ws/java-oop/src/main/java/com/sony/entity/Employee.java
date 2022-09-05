package com.sony.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Employee {

	private int id; // 4 bytes
	private String name; // 8 bytes
	private double salary; // 8 bytes
	
	public Employee(int id, String name) {
		this.setId(id); // avoid this.id = id;
		this.setName(name);
	}

}
