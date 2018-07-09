package com.springBoot.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.model.Employees;

@Repository
public interface EmployeeRepository extends CrudRepository<Employees, Integer>{

	public Employees findByFullName(String fullName);
	
	public Employees findByEmail(String email);
	
}
