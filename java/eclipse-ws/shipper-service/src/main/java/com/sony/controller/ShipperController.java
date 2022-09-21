package com.sony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sony.entity.Shipper;
import com.sony.service.ShipperService;

@RestController
@RequestMapping("/api/shippers")
public class ShipperController {

	@Autowired
	private ShipperService service;

	@GetMapping("/{id}")
	public ResponseEntity<Object> handleGetOne(@PathVariable Integer id) {

		Shipper shipper = service.getShipperById(id);
		if (shipper == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(shipper);

	}
}
