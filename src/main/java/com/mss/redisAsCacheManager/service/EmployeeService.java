package com.mss.redisAsCacheManager.service;

import java.util.List;
import java.util.Optional;

import com.mss.redisAsCacheManager.ResourceNotFoundException;
import com.mss.redisAsCacheManager.model.Employee;

public interface EmployeeService {
	public Employee insertEmployee(Employee e);

	public Employee updateEmployee(int empId, Employee e) throws ResourceNotFoundException;

	public void deleteEmployee(int empId) throws ResourceNotFoundException;

	public Employee getEmployeeById(int empId) throws ResourceNotFoundException;

	public List<Employee> getAllEmployees();
}
