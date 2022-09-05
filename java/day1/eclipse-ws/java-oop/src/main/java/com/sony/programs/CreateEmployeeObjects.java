package com.sony.programs;

import com.sony.entity.Employee;

public class CreateEmployeeObjects {

	public static void main(String[] args) {
		
		// e1 is a reference type variable
		Employee e1, e2;
		
		System.out.println("pass-1");
		e1 = new Employee(); // e1 refers to an instance of Employee
		System.out.println("pass-2");
		
		e1.setId(100);
		e1.setName("John");
		e1.setSalary(23500);
		
		System.out.println("pass-3");
		e2 = new Employee(234, "John Miller");
		System.out.println("pass-4");
		e2.setSalary(34500);
		
		
		
		System.out.println(e1);
		System.out.println(e2);
		
		
	}
}

