package com.sony.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="employees")
@ToString(exclude="reportsTo")
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
	@Embedded
	private Address address;
	@Column(name="home_phone")
	private String homePhone;
	private String extension;
	private byte[] photo;
	private String notes;
	@ManyToOne
	@JoinColumn(name="reports_to")
	private Employee reportsTo;
}
