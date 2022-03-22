package com.app.demo.httpresponse;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
public class HttpStatusResponse {
	private int statusCode;
	private Object data;
	private String message;
	
	public static HttpStatusResponse setHttpResponse(int code,Object data, String message) {
		HttpStatusResponse httpResponse = new HttpStatusResponse();
		//httpResponse.setTotalRecords(null);
		httpResponse.setStatusCode(code);
		httpResponse.setData(data);
		httpResponse.setMessage(message);
		return httpResponse;
		
	}	
	
	public static HttpStatusResponse setFailedResponse(int code,Object data, String message) {
		HttpStatusResponse failedResponse = new HttpStatusResponse();
		failedResponse.setStatusCode(code);
		failedResponse.setData(data);
		failedResponse.setMessage(message);
		return failedResponse;
	}


}


