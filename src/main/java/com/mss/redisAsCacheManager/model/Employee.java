package com.mss.redisAsCacheManager.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class Employee implements Serializable{
	@Id
	@GeneratedValue
	private int empId;
	private String empName;
	private double empSal;

}
