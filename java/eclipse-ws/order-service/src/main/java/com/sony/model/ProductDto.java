package com.sony.model;

import lombok.Data;

@Data
public class ProductDto {
/*
  "id": 41,
  "name": "Jack's New England Clam Chowder",
  "quantityPerUnit": "12 - 12 oz cans",
  "categoryId": 8,
  "supplierId": 19,
  "unitPrice": 9.65,
  "unitsInStock": 85,
  "unitsOnOrder": 0,
  "reorderLevel": 10,
  "discontinued": false
 */
	
	private Integer id;
	private String name;
	private String quantityPerUnit;
	private Double unitPrice;
	private Integer unitsInStock;
	private Integer unitsOnOrder;
	private Integer reorderLevel;
	private Boolean discontinued;
}
