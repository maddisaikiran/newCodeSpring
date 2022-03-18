package com.example.demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.example.demo.exception.ValidationException;
import com.example.demo.httpresponse.HttpStatusResponse;
import com.example.demo.util.ResponseUtil;

@ControllerAdvice
public class ControllerAdvicerConfig {
	
	
//	public ResponseEntity<Response> handleValidationException(ValidationException e) {
//		return ResponseUtil.prepareHttpResponse(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
//	}
	
	public ResponseEntity<HttpStatusResponse> handleValidationException1(ValidationException e) {
		return ResponseUtil.prepareSuccessResponse(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
	}
	
	@ExceptionHandler
	public ResponseEntity<HttpStatusResponse> handleValidationException(ValidationException e) {
		return ResponseUtil.prepareSuccessResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, e.getMessage());
	}
	

}
