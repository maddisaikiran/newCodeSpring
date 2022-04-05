package com.app.demo.exception;

public class ValidationException extends RuntimeException {
	public ValidationException(String errMsg, Throwable t) {
		super(errMsg, t);
	}
	
	public ValidationException(String errMsg) {
		super(errMsg);
	}
}
