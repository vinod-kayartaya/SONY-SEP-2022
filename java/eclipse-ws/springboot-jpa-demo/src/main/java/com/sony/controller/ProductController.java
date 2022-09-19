package com.sony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sony.entity.ErrorInfo;
import com.sony.entity.Product;
import com.sony.entity.ProductList;
import com.sony.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PatchMapping(path="/{id}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> handlePatch(
			@PathVariable Integer id,
			@RequestBody Product product) {
		try {
			product = service.patchProduct(id, product);
			if(product==null) {
				return ResponseEntity.status(404).body(new ErrorInfo("Invalid id supplied"));
			}
			return ResponseEntity.ok(product);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ErrorInfo(e.getMessage()));
		}
	}
	
	
	
	@PutMapping(path="/{id}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> handlePut(
			@PathVariable Integer id,
			@RequestBody Product product) {
		try {
			product = service.updateProduct(id, product);
			return ResponseEntity.ok(product);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ErrorInfo(e.getMessage()));
		}
	}

	
	
	
	@PostMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, 
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Object> handlePost(@RequestBody Product product) {
		try {
			product = service.addNewProduct(product);
			return ResponseEntity.status(HttpStatus.CREATED).body(product);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(new ErrorInfo(e.getMessage()));
		}
	}

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ProductList handleGetProducts(@RequestParam(name = "_page", defaultValue = "1") Integer pageNum,
			@RequestParam(name = "_limit", defaultValue = "10") Integer pageSize,
			@RequestParam(name = "_sort", defaultValue = "id") String sortBy) {
		return new ProductList(service.getAllProducts(pageNum, pageSize, sortBy));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> handleGetOneProduct(@PathVariable Integer id) {
		Product product = service.getProductById(id);
		if (product == null) {
			return ResponseEntity.status(404).body(new ErrorInfo("No data found for id: " + id));
		}
		return ResponseEntity.ok(product);
	}

}
