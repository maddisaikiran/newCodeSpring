package com.app.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.demo.exception.ValidationException;
import com.app.demo.httpresponse.HttpStatusResponse;
import com.app.demo.util.ResponseUtil;

@ControllerAdvice
public class ControllerAdvicerConfig {
	
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<HttpStatusResponse> handleValidationException(ValidationException e) {
		return ResponseUtil.prepareFailedResponse(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
	}
	

}
