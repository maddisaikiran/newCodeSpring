package com.example.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.example.demo.httpresponse.HttpStatusResponse;

public class ResponseUtil {

	public static ResponseEntity<HttpStatusResponse> prepareSuccessResponse(int statusCode, Object payload,String mesage){
		//Response responseDTO = new Response(statusCode, payload, mesage);
		
		
		return new ResponseEntity<>(HttpStatusResponse.setHttpResponse(statusCode,payload,mesage),HttpStatus.OK);
	}
	
	
	
}