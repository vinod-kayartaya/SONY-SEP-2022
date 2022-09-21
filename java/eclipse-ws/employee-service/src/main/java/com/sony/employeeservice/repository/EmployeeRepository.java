package com.sony.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sony.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
