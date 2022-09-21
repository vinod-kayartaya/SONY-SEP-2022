package com.sony.employeeservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name="EMPLOYEES")
public class Employee {
	@Id
	@Column(name="employee_id")
	private Integer employeeId;
	@Column(name="first_name")
	private String firstname;
	@Column(name="last_name")
	private String lastname;
	private String title;
	@Column(name="title_of_courtesy")
	private String titleOfCourtesy;
	@Column(name="birth_date")
	private Date birthDate;
	@Column(name="hire_date")
	private Date hireDate;
	private String address;
	private String city;
	private String region;
	@Column(name = "postal_code")
	private String postalCode;
	private String country;
	@Column(name="home_phone")
	private String homePhone;
	private String extension;
}
