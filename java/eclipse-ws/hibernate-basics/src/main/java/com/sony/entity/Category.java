package com.sony.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="categories")
public class Category {
	@Id
	@Column(name="category_id")
	private Integer categoryId;
	@Column(name="category_name")
	private String category_name;
	private String description;
	private byte[] picture;
	
	// ONE category has MANY products
	@OneToMany
	@JoinColumn(name="category_id") // FK in products table
	List<Product> products;
}
