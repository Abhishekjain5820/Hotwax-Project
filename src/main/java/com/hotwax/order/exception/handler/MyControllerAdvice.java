package com.hotwax.order.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hotwax.order.model.ApiError;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleException(Exception ex) {
		// Log the exception
		ex.printStackTrace();
		// Create an APIError object
		ApiError error = new ApiError(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		// Return ResponseEntity with the APIError object and HTTP status
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
