package com.app.demo.httpresponse;

import java.util.Map;

import lombok.Data;

@Data
public class HttpUserErrorResponse {
	private int statusCode;
	private String message;
	private Map<String,String> errors;
	
public static HttpUserErrorResponse setFailedResponse(int code, Map<String, String> error) {
		
	HttpUserErrorResponse httpResponse = new HttpUserErrorResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setErrors(error);
		return httpResponse;
	}
public static HttpErrorResponse setCommentFailedResponse(int code, String message) {
HttpErrorResponse httpResponse = new HttpErrorResponse();
httpResponse.setStatusCode(code);
httpResponse.setMessage(message);
return httpResponse;
}	



}
