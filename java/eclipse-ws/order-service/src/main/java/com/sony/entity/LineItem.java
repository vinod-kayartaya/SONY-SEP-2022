package com.sony.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ORDER_DETAILS")
public class LineItem implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "order_id")
	private Integer orderId;
	@Id
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "unit_price")
	private Double unitPrice;
	private Integer quantity;
	private Double discount;

}
