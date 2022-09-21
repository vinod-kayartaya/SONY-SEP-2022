package com.sony.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {
	@Id
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "employee_id")
	private Integer employeeId;
	@Column(name = "order_date")
	private Date orderDate;
	@Column(name = "required_date")
	private Date requiredDate;
	@Column(name = "shipped_date")
	private Date shippedDate;
	@Column(name = "ship_via")
	private Integer shipperId;
	private Double freight;
	@Column(name = "ship_name")
	private String shippedToName;
	@Column(name = "ship_address")
	private String shippedToAddress;
	@Column(name = "ship_city")
	private String shippedToCity;
	@Column(name = "ship_region")
	private String shippedToRegion;
	@Column(name = "ship_postal_code")
	private String shippedToPostalCode;
	@Column(name = "ship_country")
	private String shippedToCountry;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private List<LineItem> lineItems;
}
