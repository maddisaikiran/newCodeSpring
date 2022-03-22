package com.app.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
	private int statusCode;
	private Object data;
	private String message;
}
