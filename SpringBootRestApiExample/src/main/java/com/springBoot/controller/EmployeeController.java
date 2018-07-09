package com.springBoot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.model.Employees;
import com.springBoot.service.IEmployeeSevice;

/**
 * @author Naved Khan
 *
 */
@RestController
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	public IEmployeeSevice employee;

	/**
	 * @return List of All employees
	 */
	@GetMapping("/getAllEmployees")
	public List<Employees> getAll() {
		return employee.getAll();
	}

	/**
	 * @param email
	 * @return employee object
	 */
	@GetMapping("/getEmpByEmail")
	public ResponseEntity<Employees> getEmpByEmail(String email) {
		Employees emp = null;
		try {
			emp = employee.findByEmail(email);
		} catch (Exception e) {
			logger.error("Exception in getByEmail "+email);
			throw new RuntimeException(e.getMessage());
		}
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}

	
}
