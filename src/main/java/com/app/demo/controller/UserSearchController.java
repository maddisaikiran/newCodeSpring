package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.model.User;
import com.app.demo.service.UserSearchService;


@RestController
@CrossOrigin
public class UserSearchController {
	@Autowired
	private UserSearchService serv1;
	
//	@GetMapping("/users")
//	public ResponseEntity<HttpStatusResponse> List<User> getAllUsers(){
//		User user = null;
//		user = serv1.getAllUsers();
//		return ResponseUtil.prepareSuccessResponse(HttpStatus.OK.value(),user,"Data retrevial Successfully");
//		return serv1.getAllUsers();
//	}
	
	@GetMapping("/users")
	public ResponseEntity <List<User>> getAllUsers(){
		List<User> u = null;
		u = serv1.getAllUsers();
	return new ResponseEntity(u,HttpStatus.OK);
	}
}
