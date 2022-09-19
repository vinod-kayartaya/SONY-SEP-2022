package com.sony.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@Entity
@Table(name = "PRODUCTS")
public class Product {
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "product_id")
	private Integer id;
	@Column(name = "product_name", unique = true)
	private String name;
	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;
	@Column(name = "category_id")
	private Integer categoryId;
	@Column(name = "supplier_id")
	private Integer supplierId;
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
