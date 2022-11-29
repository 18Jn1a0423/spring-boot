package com.mss.redisAsCacheManager.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mss.redisAsCacheManager.model.Employee;
import com.mss.redisAsCacheManager.service.EmployeeService;
import com.mss.redisAsCacheManager.ResourceNotFoundException;
import com.mss.redisAsCacheManager.Repo.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Employee insertEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Override
	@CachePut(value = "employees", key = "#empId")
	public Employee updateEmployee(int empId, Employee e) throws ResourceNotFoundException {
		// return repo.save(e); or
		Employee emp = repo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee"));
		emp.setEmpName(e.getEmpName());
		emp.setEmpSal(e.getEmpSal());
		return repo.save(emp);

	}

	@Override
	@CacheEvict(value = "employees", key = "#empId")
	public void deleteEmployee(int empId) throws ResourceNotFoundException {
		// repo.deleteById(empId);
		Employee emp = repo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee"));
		repo.delete(emp);

	}

	@Override
	@Cacheable(value = "employees", key = "#empId")
	public Employee getEmployeeById(int empId) throws ResourceNotFoundException {
		// return repo.findById(empId); for this the return type is optional<Employee>
		Employee emp = repo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Employee"));
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

}
