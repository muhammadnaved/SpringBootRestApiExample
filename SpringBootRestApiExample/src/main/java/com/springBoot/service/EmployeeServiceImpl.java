package com.springBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.model.Employees;

@Service
public class EmployeeServiceImpl implements IEmployeeSevice {

    @Autowired
    public EmployeeRepository repository;
    
	@Override
	public List<Employees> getAll() {
		return (List<Employees>) repository.findAll();
	}

	@Override
	public Employees findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	
	
}
