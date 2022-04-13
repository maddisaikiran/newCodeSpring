package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.constants.Constants;
import com.app.demo.httpresponse.HttpGetStatusResponse;
import com.app.demo.model.User;
import com.app.demo.service.UserSearchService;
import com.app.demo.util.ResponseUtil;


@RestController
@CrossOrigin
public class UserSearchController {
	@Autowired
	private UserSearchService userSearchService;
	
	@GetMapping("/users")
	public ResponseEntity<HttpGetStatusResponse> getAllUser(){
		List<User> users = userSearchService.getAllUser();
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(),users,Constants.USER_DATA_RETRIVAL);
		
	}
	
}
