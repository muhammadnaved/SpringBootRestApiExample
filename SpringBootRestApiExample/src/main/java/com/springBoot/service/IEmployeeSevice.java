package com.springBoot.service;

import java.util.List;

import com.springBoot.model.Employees;

public interface IEmployeeSevice {

	
	public List<Employees> getAll();
	
	public Employees findByEmail(String email);

	
}
