package com.app.demo.exception;
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {

	public BusinessException() {
		super();
	}
	public BusinessException(String message) {
		super(message);
	}

}
