package com.sony.programs;

import com.sony.entity.Customer;
import com.sony.entity.Employee;
import com.sony.entity.Printable;

public class InterfaceDemo {
	
	// polymorphic method.
	static void doPrint(Printable p) {
		p.print();
		p.printAsJson();
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Customer c1 = new Customer();
		c1.setId(123);
		c1.setFirstname("Vinod");
		c1.setLastname("Kumar");
		c1.setEmail("vinod@vinod.co");
		c1.setPhone("9731424784");
		c1.getAddress().setHouseNameNo("TF-1 Elegant Elite");
		c1.getAddress().setStreet("1st cross, 1st main");
		c1.getAddress().setArea("ISRO layout");
		c1.getAddress().setCity("Bangalore");
		c1.getAddress().setState("Karnataka");
		c1.getAddress().setPincode("560078");
		c1.getAddress().setCountry("India");
		
		Employee e1 = new Employee(234, "John Miller");
		e1.setSalary(34500);
		
		Laptop l1 = new Laptop(11, "Lenovo Z560", 45000, 14, ScreenTypes.LED);
		l1.setCpu("Intel i9 2900GHz 6 core");
		l1.setRam("16Gi");
		l1.setStorage("1 TB");
		
		doPrint(c1); // c1 is an instanceof Customer, Object and Printable
		doPrint(e1); // e1 is an instanceof Employee, Object, and Printable
		doPrint(l1); // l1 is an instanceof Laptop, Product, Object, and Printable
		// doPrint("Vinod"); // String objects are not "Printable"
	}

}
