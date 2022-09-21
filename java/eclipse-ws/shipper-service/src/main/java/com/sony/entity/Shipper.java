package com.sony.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@Entity
@Table(name = "SHIPPERS")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Shipper {
	@Id
	@Column(name="shipper_id")
	private Integer shipperId;
	@Column(name="company_name")
	private String companyName;
	private String phone;
}







