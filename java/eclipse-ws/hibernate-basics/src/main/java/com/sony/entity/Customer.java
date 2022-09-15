package com.sony.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="customers")
public class Customer {
	@Id
	@Column(name="customer_id")
	private String customerId;
	@Column(name="company_name")
	private String companyName;
	@Column(name="contact_name")
	private String contactName;
	@Column(name="contact_title")
	private String contactTitle;
	
	@Embedded
	private Address address;
	
	private String phone;
	private String fax;
}
