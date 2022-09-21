package com.sony.model;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class OrderDto {
	private Integer orderId;
	
	private CustomerDto customer;
	private EmployeeDto employee;
	
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private Double freight;
	private ShipperDto shippedBy;

	private String shippedToName;
	private String shippedToAddress;
	private String shippedToCity;
	private String shippedToRegion;
	private String shippedToPostalCode;
	private String shippedToCountry;
	
	private List<LineItemDto> lineItems;
}
