package com.sony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sony.model.OrderDto;
import com.sony.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> handleGetOne(@PathVariable Integer id){
		OrderDto orderDto = service.getOrderById(id);
		
		if(orderDto==null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(orderDto);
	}
}














