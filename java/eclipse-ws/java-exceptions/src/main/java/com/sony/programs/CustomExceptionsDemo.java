package com.sony.programs;

import com.sony.entity.Employee;
import com.sony.entity.EmployeeSalaryOutOfRangeException;
import com.sony.entity.EmptyNameException;
import com.sony.entity.InvalidEmployeeIdException;
import com.sony.entity.NameTooLongException;
import com.sony.entity.NullNameException;

public class CustomExceptionsDemo {

	public static void main(String[] args) {

		Employee e1 = new Employee();

		try {
			e1.setId(-1122);
			e1.setName("Ravi");
			e1.setSalary(-45600.0);

			System.out.println(e1);
		} catch (InvalidEmployeeIdException ex) {
			System.out.println("Invalid id supplied");
		} catch (NullNameException ex) {
			System.out.println("Employee name cannot be null");
		} catch (EmptyNameException ex) {
			System.out.println("Employee name cannot be blank");
		} catch (NameTooLongException ex) {
			System.out.println("Employee name must be less than 20 letters");
		} catch (EmployeeSalaryOutOfRangeException ex) {
			System.out.println("Salary must be between 15000 and 999999");
		}

		System.out.println("End of main()");

	}
}
