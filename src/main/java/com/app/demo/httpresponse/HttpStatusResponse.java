package com.app.demo.httpresponse;



import lombok.Data;

@Data
public class HttpStatusResponse {
	private int statusCode;
	private Object data;
	private String message;
	
	public static HttpStatusResponse setHttpResponse(int code,Object data, String message) {
		HttpStatusResponse httpResponse = new HttpStatusResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setData(data);
		httpResponse.setMessage(message);
		return httpResponse;
	}
public static HttpStatusResponse setFailedResponse(int code,Object data,String message) {
	HttpStatusResponse httpResponse = new HttpStatusResponse();
		httpResponse.setStatusCode(code);
		httpResponse.setMessage(message);
		httpResponse.setData(data);
		return httpResponse;
	}	
}
