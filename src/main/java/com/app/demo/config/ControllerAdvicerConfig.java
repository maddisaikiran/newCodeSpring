package com.app.demo.config;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.demo.exception.ResourceNotFoundException;
import com.app.demo.httpresponse.HttpErrorResponse;
import com.app.demo.httpresponse.HttpUserErrorResponse;
import com.app.demo.util.ResponseUtil;


@ControllerAdvice
public class ControllerAdvicerConfig {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<HttpUserErrorResponse> handleInvalidArgument(MethodArgumentNotValidException e){
		Map<String,String> error = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(err -> {
			error.put(err.getField(), err.getDefaultMessage());
		});
		return ResponseUtil.prepareFailedResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),error);
	}
	

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<HttpUserErrorResponse> handleValidationException(NoSuchElementException e) {
		Map<String,String> error = new HashMap<>();
		error.put("error", e.getMessage());
	
		return ResponseUtil.prepareFailedResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),error);

	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<HttpErrorResponse> handleResourceNotFound(ResourceNotFoundException e){
		return ResponseUtil.setCommentFailedResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
	}
}
