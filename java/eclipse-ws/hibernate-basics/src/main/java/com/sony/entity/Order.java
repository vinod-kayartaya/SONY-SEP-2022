package com.sony.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "order_id")
	private Integer orderId;
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	@Column(name = "order_date")
	private Date orderDate;
	@Column(name = "required_date")
	private Date requiredDate;
	@Column(name = "shipped_date")
	private Date shippedDate;
	
	@ManyToOne
	@JoinColumn(name="ship_via")
	private Shipper shipper;
	
	private Double freight;
	
	@Column(name="ship_name")
	private String shipToName;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="streeAddress", column=@Column(name="ship_address")),
		@AttributeOverride(name="city", column=@Column(name="ship_city")),
		@AttributeOverride(name="region", column=@Column(name="ship_region")),
		@AttributeOverride(name="country", column=@Column(name="ship_country")),
		@AttributeOverride(name="postalCode", column=@Column(name="ship_postal_Code")),
	})
	private Address shipToAddress;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="order_id")
	private List<LineItem> lineItems;
	
}
















