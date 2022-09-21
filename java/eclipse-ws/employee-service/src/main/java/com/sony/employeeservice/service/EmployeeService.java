package com.sony.employeeservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.employeeservice.entity.Employee;
import com.sony.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	public Employee getEmployeeById(Integer id) {
		Optional<Employee> op = repo.findById(id);
		return op.isEmpty() ? null : op.get();
	}
}
