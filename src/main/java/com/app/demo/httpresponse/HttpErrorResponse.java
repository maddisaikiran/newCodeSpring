package com.app.demo.httpresponse;

import lombok.Data;

@Data
public class HttpErrorResponse {
	private int statusCode;
	private String message;
}
