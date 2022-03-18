package com.example.demo.BusinessException;
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException{
	public BusinessException() {
		super();
	}
	public BusinessException(String message) {
		super(message);
	}

}
