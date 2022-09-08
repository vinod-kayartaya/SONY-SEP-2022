package com.sony.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Comparable<Product> {
	private int id;
	private String name;
	private double price;

	// this method determines the natural ordering of a product
	@Override
	public int compareTo(Product other) {
		// return 0 if "this" and "other" are same
		// return -ve if "this" is smaller than "other"
		// return +ve if "this" is greater than "other"
		
		return this.id - other.id;
		// return this.name.compareTo(other.name);
		// return Double.compare(this.price, other.price);
	}
}
