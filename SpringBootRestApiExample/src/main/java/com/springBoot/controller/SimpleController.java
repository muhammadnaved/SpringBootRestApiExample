package com.springBoot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.model.Employees;
import com.springBoot.service.IEmployeeSevice;

/**
 * @author Naved Khan
 *
 */
@RestController
public class SimpleController {

	private final Logger logger = LoggerFactory.getLogger(SimpleController.class);

	@Autowired
	public IEmployeeSevice employee;

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping("/login")
	public ResponseEntity<Employees> getHomePage(HttpServletRequest request, HttpServletResponse response) {
		String username = (String) request.getParameter("username");
		Employees emp = employee.findByEmail(username);
		if (emp == null) {
			logger.error("Aunthetication Failed.");
			return new ResponseEntity<Employees>(emp, HttpStatus.UNAUTHORIZED);
		}
		char[] password = request.getParameter("password").toCharArray();
		if (emp.getEmail().equals(username) && emp.getEmpPassword().equals(String.valueOf(password))) {
			logger.info(username + " Employee logged in.");
			return new ResponseEntity<Employees>(emp, HttpStatus.OK);
		} else {
			logger.error("Aunthetication Failed.");
			return new ResponseEntity<Employees>(emp, HttpStatus.UNAUTHORIZED);
		}
	}

}
