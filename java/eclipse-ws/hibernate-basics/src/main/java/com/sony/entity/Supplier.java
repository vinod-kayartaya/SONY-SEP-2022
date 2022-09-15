package com.sony.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="suppliers")
@ToString(exclude= {"products"})
public class Supplier {
	@Id
	@Column(name="supplier_id")
	private Integer supplierId;
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
	@Column(name="home_page")
	private String homepage;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="supplier_id") // FK in products table
	private List<Product> products;
}
