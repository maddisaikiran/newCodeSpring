package com.app.demo.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.constants.*;
import com.app.demo.httpresponse.HttpStatusResponse;
import com.app.demo.model.User;
import com.app.demo.service.UserService;
import com.app.demo.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping(value="/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<HttpStatusResponse> addUser(@Valid @RequestBody User user){

		 user  = userService.addUser(user);
		logger.info("User Created successfully");
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), user,Constants.USER_CREATED_SUCCESS);			
		
	}

	@PutMapping
	public ResponseEntity<HttpStatusResponse> updateUser(@Valid @RequestBody User user) {
		User userDetails = userService.updateUser(user);
		logger.info("User Updated successfully");
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), userDetails,Constants.USER_UPDATE_SUCCESS);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatusResponse> deleteUser(@PathVariable Integer id){
		userService.deleteUser(id);
		logger.info("User Deleted Successfully");
		return ResponseUtil.prepareSuccessResponse(HttpStatus.NO_CONTENT.value(), id,Constants.USER_DELETE_SUCCESS);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HttpStatusResponse> getUserDetailsById(@PathVariable int id){
		User user = userService.getUserById(id);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.OK.value(), user,Constants.USER_DATA_RETRIVAL);
	}

	@PostMapping("/login")
	public User getUserByEmailAndPassword(@RequestBody User user) {
		logger.info("User login successfully");
		
	  return userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
		
	}
	
	@PutMapping("/{id}/status/{userStatus}")
	public ResponseEntity<HttpStatusResponse> updateUserStatus(@PathVariable Integer id, @PathVariable boolean userStatus) {
		User user = userService.updateUserStatus(id,userStatus);
		logger.info("User status Updated Successfully");
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), user,Constants.USER_STATUS_UPDATED);
	}
}
