package com.app.demo.util;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.demo.httpresponse.HttpStatusResponse;

public class ResponseUtil {

	public static ResponseEntity<HttpStatusResponse> prepareSuccessResponse(int statusCode, Object payload,String mesage){
		return new ResponseEntity<>(HttpStatusResponse.setHttpResponse(statusCode,payload,mesage),HttpStatus.OK);
	}
	
	public static ResponseEntity<HttpStatusResponse> prepareFailedResponse(int statusCode, Object payload,String mesage){
		return new ResponseEntity<>(HttpStatusResponse.setFailedResponse(statusCode, payload, mesage),HttpStatus.BAD_REQUEST);
	}
	
	public static ResponseEntity<HttpStatusResponse> prepareHttpResponse(int statusCode, Object payload,String mesage,List<Object> list1){
		return new ResponseEntity<>(HttpStatusResponse.setSuccessResponse(statusCode, payload, mesage, list1),HttpStatus.OK);
	}
	
	public static ResponseEntity<HttpStatusResponse> prepareHttpResponse(int statusCode, Object payload,String mesage){
		return new ResponseEntity<>(HttpStatusResponse.setSuccessResponse(statusCode, payload, mesage),HttpStatus.OK);
	}
	

	
}