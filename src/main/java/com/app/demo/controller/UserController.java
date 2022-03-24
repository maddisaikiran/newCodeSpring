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
import com.app.demo.exception.ValidationException;
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

	@PostMapping("")
	public ResponseEntity<HttpStatusResponse> addUser(@Valid @RequestBody User user) throws ValidationException {

		 User user2  = userService.addUser(user);
		logger.info("User Created successfully");
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), user2,Constants.MESSAGE);
		
	}

	@PutMapping("")
	public ResponseEntity<HttpStatusResponse> updateUser(@Valid @RequestBody User user) throws ValidationException {
		
		User user2 = userService.updateUser(user);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), user2,Constants.MESSAGE_UPDATE);
	}

	@DeleteMapping("s/{id}")
	public ResponseEntity<HttpStatusResponse> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		logger.info("User Deleted Successfully");
		return ResponseUtil.prepareSuccessResponse(HttpStatus.NO_CONTENT.value(), id,Constants.MESSAGE_DELETE);
		
	}
	

	@GetMapping("/user/{id}")
	public ResponseEntity<HttpStatusResponse> getUserDetailsById(@PathVariable int id) {
		User user = userService.getUserById(id);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.OK.value(), user,Constants.MESSAGE_RETRIVAL);
	}

	@PostMapping("/login")
	public User getUserByEmailAndPassword(@RequestBody User user) {
		
		return userService.getUserByEmailAndPassword(user.getEmail(), user.getPassword());
	}
	
	@PutMapping("/{id}/userStatus/{userStatus}")
	public ResponseEntity<HttpStatusResponse> updateUserStatus(@PathVariable Integer id, @PathVariable boolean userStatus) {
		User user = userService.updateUserStatus(id,userStatus);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), user,Constants.MESSAGE_STATUS);
	}
	

}
