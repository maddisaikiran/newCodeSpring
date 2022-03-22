package com.app.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.demo.httpresponse.HttpStatusResponse;

public class ResponseUtil {

	public static ResponseEntity<HttpStatusResponse> prepareSuccessResponse(int statusCode, Object payload,String mesage){
		//Response responseDTO = new Response(statusCode, payload, mesage);
		
		
		return new ResponseEntity<>(HttpStatusResponse.setHttpResponse(statusCode,payload,mesage),HttpStatus.OK);
	}
	
	public static ResponseEntity<HttpStatusResponse> prepareFailedResponse(int statusCode, Object payload,String mesage){
		return new ResponseEntity<>(HttpStatusResponse.setFailedResponse(statusCode, payload, mesage),HttpStatus.BAD_REQUEST);
	}
	
	
}