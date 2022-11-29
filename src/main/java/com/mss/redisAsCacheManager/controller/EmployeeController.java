package com.mss.redisAsCacheManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mss.redisAsCacheManager.ResourceNotFoundException;
import com.mss.redisAsCacheManager.model.Employee;
import com.mss.redisAsCacheManager.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@GetMapping("/employee/{empId}")
	public Employee getOneEmployee(@PathVariable int empId) throws ResourceNotFoundException {
		return employeeService.getEmployeeById(empId);
	}

	@PutMapping("/employee/{empId}")
	public Employee updateEmployee(@PathVariable int empId, @RequestBody Employee employee)
			throws ResourceNotFoundException {
		Employee emp = employeeService.updateEmployee(empId, employee);
		return emp;
	}

	@DeleteMapping("/employee/{empId}")
	public String deleteEmployee(@PathVariable int empId) throws ResourceNotFoundException {
		employeeService.deleteEmployee(empId);
		return "Employee deleted=>" + empId;
	}
}
