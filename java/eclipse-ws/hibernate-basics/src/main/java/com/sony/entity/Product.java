package com.sony.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "products")
@ToString
public class Product {
	@Id
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "product_name")
	private String productName;

	// MANY products belong to ONE category
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	@Column(name = "unit_price")
	private Double unitPrice;
	@Column(name = "units_in_stock")
	private Integer unitsInStock;
	@Column(name = "units_on_order")
	private Integer unitsOnOrder;
	@Column(name = "reorder_level")
	private Integer reorderLevel;
	private Boolean discontinued;
}
