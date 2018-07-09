package com.springBoot.exception;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Naved Khan
 *
 */
@ControllerAdvice
@RestController
public class RestExceptionHandler {


	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Not Found");
		response.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> runTimeEception(RuntimeException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Bad Request");
		response.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ExceptionResponse> runTimeEception(IllegalArgumentException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Illegal Argument");
		response.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NO_CONTENT);
	}

}
