package com.sony.model;

import lombok.Data;

@Data
public class LineItemDto {
	private ProductDto product;
	private Integer quantity;
	private Double unitPrice;
	private Double discount;
}
