package com.sony.entity;

import lombok.Data;

@Data
public class Supplier {
	private int id;
	private String companyName;
	private String contactPerson;
	private String email;
	private String phone;
	private Address address = new Address(); // aggregation; encourages reusability
}
