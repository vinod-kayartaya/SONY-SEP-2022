package com.sony.programs;

import com.sony.entity.Customer;

public class AggregationDemo {

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
		
		System.out.println(c1);
		
	}

}
