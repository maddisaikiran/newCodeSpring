package com.app.demo.util;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.demo.httpresponse.HttpErrorResponse;
import com.app.demo.httpresponse.HttpGetStatusResponse;
import com.app.demo.httpresponse.HttpUserErrorResponse;
import com.app.demo.httpresponse.HttpStatusResponse;

public class ResponseUtil {

	public static ResponseEntity<HttpStatusResponse> prepareSuccessResponse(int statusCode, Object payload,String mesage){
		return new ResponseEntity<>(HttpStatusResponse.setHttpResponse(statusCode,payload,mesage),HttpStatus.OK);
	}
	
	public static ResponseEntity<HttpUserErrorResponse> prepareFailedResponse(int statusCode,Map<String,String> map){
		return new ResponseEntity<>(HttpUserErrorResponse.setFailedResponse(statusCode,map),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static ResponseEntity<HttpGetStatusResponse> prepareHttpResponse(int statusCode, Object payload,String mesage){
		return new ResponseEntity<>(HttpGetStatusResponse.setSuccessResponse(statusCode, payload, mesage),HttpStatus.OK);
	}
	public static ResponseEntity<HttpErrorResponse> setCommentFailedResponse(int statusCode,String message){
		return new ResponseEntity<>(HttpUserErrorResponse.setCommentFailedResponse(statusCode,message),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}