package com.springBoot.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Naved Khan
 *
 */
@RestController
public class ErrorHandler implements ErrorController{
	
	private final String PATH= "/error";

	@Override
	public String getErrorPath() {
		return PATH;
	}
	
	@RequestMapping(PATH)
	public ResponseEntity<String> handleError(HttpServletRequest request) {
	    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	     
	    if (status != null) {
	        Integer statusCode = Integer.valueOf(status.toString());
	     
	        if(statusCode == HttpStatus.NOT_FOUND.value()) {
	        	return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
	        }
	        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	        	return new ResponseEntity<String>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    return new ResponseEntity<String>("Something went wrong.", HttpStatus.BAD_REQUEST);
	}
}
