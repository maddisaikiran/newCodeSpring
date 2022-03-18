package com.example.demo.exception;

public class ValidationException extends Exception {
	public ValidationException(String errMsg, Throwable t) {
		super(errMsg, t);
	}
	
	public ValidationException(String errMsg) {
		super(errMsg);
	}
}
