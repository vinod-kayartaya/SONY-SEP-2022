package com.sony.entity;

import lombok.Data;

@Data
public class Address {
	private String houseNameNo; 
	private String street;
	private String area;
	private String city;
	private String state;
	private String pincode;
	private String country;
}
