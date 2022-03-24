package com.app.demo.httpresponse;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
//@AllArgsConstructor
public class HttpStatusResponse {
	private int statusCode;
	private Object data;
	private String message;
	private List<Object> list1 = new ArrayList<>();
	
	public static HttpStatusResponse setHttpResponse(int code,Object data, String message) {
		HttpStatusResponse httpResponse = new HttpStatusResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setData(data);
		httpResponse.setMessage(message);
		return httpResponse;
		
	}	
	public static HttpStatusResponse setFailedResponse(int code,Object data, String message) {
		HttpStatusResponse httpResponse = new HttpStatusResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setData(data);
		httpResponse.setMessage(message);
		return httpResponse;
	}	
	
	public static HttpStatusResponse setSuccessResponse(int code,Object data, String message) {
		HttpStatusResponse successResponse = new HttpStatusResponse();
		successResponse.setStatusCode(code);
		successResponse.setData(data);
		successResponse.setMessage(message);
		successResponse.setList1(Arrays.asList(data));
		return successResponse;
	}
	public static HttpStatusResponse setSuccessResponse(int code,Object data, String message, List<Object> list1) {
		HttpStatusResponse successResponse = new HttpStatusResponse();
		successResponse.setStatusCode(code);
		successResponse.setData(data);
		successResponse.setMessage(message);
		successResponse.setList1(Arrays.asList(data));
		return successResponse;
	}



}


