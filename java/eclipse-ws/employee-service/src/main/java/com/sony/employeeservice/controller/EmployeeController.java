package com.sony.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sony.employeeservice.entity.Employee;
import com.sony.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/{id}")
	public ResponseEntity<Object> handleGetOne(@PathVariable Integer id) {
		Employee emp = service.getEmployeeById(id);
		return emp == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(emp);
	}
}
