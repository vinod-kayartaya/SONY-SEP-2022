package com.sony.entity;

public class Employee {
	private int id;
	private String name;
	private double salary;

	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id <= 0 || id > 99999) {
			throw new InvalidEmployeeIdException("Invalid id. Must be between 1 and 99999");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null) {
			throw new NullNameException("Employee name cannot be null");
		}
		if (name.trim().length() == 0) {
			throw new EmptyNameException("Name cannot be empty or just spaces");
		}
		if (name.trim().length() > 20) {
			throw new NameTooLongException("Name cannot exceed 20 letters");
		}
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary < 15000 || salary > 999999) {
			throw new EmployeeSalaryOutOfRangeException("Invalid salary. Must be between 15000 and 999999");
		}
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
