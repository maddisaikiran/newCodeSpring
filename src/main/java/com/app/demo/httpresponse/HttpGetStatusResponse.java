package com.app.demo.httpresponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
public class HttpGetStatusResponse {
	private int statusCode;
	private Object data;
	private String message;
	private List<Object> list = new ArrayList<>();
	
	public static HttpGetStatusResponse setSuccessResponse(int code,Object data, String message) {
		HttpGetStatusResponse successResponse = new HttpGetStatusResponse();
		successResponse.setStatusCode(code);
		successResponse.setData(data);
		successResponse.setMessage(message);
		successResponse.setList(Arrays.asList(data));
		return successResponse;
	}
	
	public static HttpGetStatusResponse setFailedResponse(int code,String message) {
		HttpGetStatusResponse successResponse = new HttpGetStatusResponse();
		successResponse.setStatusCode(code);
		
		successResponse.setMessage(message);
		
		return successResponse;
	}
	
	
}
