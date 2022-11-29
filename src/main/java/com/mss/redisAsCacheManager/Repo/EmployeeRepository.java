package com.mss.redisAsCacheManager.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mss.redisAsCacheManager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
