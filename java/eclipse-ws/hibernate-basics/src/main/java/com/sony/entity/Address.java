package com.sony.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
	@Column(name="address")
	private String streeAddress;
	private String city;
	private String region;
	private String country;
	@Column(name="postal_code")
	private String postalCode;
}
