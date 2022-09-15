package com.sony.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="order_details")
public class LineItem {
	@Id 
	@Column(name="order_id")
	private Integer orderId;
	@Id
	@Column(name="product_id")
	private Integer productId;
	@Column(name="unit_price")
	private Double unitPrice;
	private Integer quantity;
	private Double discount;
	
	@ManyToOne
	@JoinColumn(name="product_id", insertable = false, updatable = false)
	private Product product;
}








