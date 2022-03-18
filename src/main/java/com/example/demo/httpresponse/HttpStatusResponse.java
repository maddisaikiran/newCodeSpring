package com.example.demo.httpresponse;


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


}


