package com.app.demo.httpresponse;



import lombok.Data;

@Data
public class HttpUserStatusResponse {
	private int statusCode;
	private Object data;
	private String message;
	
	public static HttpUserStatusResponse setHttpResponse(int code,Object data, String message) {
		HttpUserStatusResponse httpResponse = new HttpUserStatusResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setData(data);
		httpResponse.setMessage(message);
		return httpResponse;
	}
public static HttpUserStatusResponse setFailedResponse(int code,Object data,String message) {
	HttpUserStatusResponse httpResponse = new HttpUserStatusResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setMessage(message);
		httpResponse.setData(data);
		return httpResponse;
	}	
}
