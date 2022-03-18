package com.example.demo.controller;
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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.*;
import com.example.demo.exception.ValidationException;
import com.example.demo.httpresponse.HttpStatusResponse;
import com.example.demo.model.User;

import com.example.demo.service.CrudUser;
import com.example.demo.util.ResponseUtil;

@RestController
@CrossOrigin
public class LoginUser {
	private static final Logger logger = LoggerFactory.getLogger(LoginUser.class);
	
	@Autowired
	private CrudUser serv;

	@PostMapping("/user")
	public ResponseEntity<HttpStatusResponse> addUser(@Valid @RequestBody User user) throws ValidationException {

		 User userRes=null;
		userRes = serv.addUser(user);
		logger.info("User authenticated successfully");
//		return ResponseUtil.prepareHttpResponse(HttpStatus.CREATED.value(), userRes, "User successfully created!");
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), userRes,Constants.message);
		
	}

	@PutMapping("/user")
	public ResponseEntity<HttpStatusResponse> updateUser(@Valid @RequestBody User user) throws ValidationException {
		
		User userRes = serv.updateUser(user);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), userRes,"User Update Successfully");
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatusResponse> deleteUser(@PathVariable int id){
		  serv.deleteUser(id);
		logger.info("User Deleted Successfully");
		//return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseUtil.prepareSuccessResponse(HttpStatus.NO_CONTENT.value(), id, "User Deleted");
		
	}
	

	@GetMapping("/user/{id}")
	public ResponseEntity<HttpStatusResponse> getUsersById(@PathVariable int id) {
		User user = serv.getUsersById(id);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.OK.value(), user, "Data retrieval successfully!");
	}

	@PostMapping("/user/login")
	public User getUserByEmailIdAndPassword(@RequestBody User user) {
		return serv.getUserByEmailIdAndPassword(user.getEmailId(), user.getPassword());
	}
	
	@PutMapping("/user/{id}/userStatus/{userStatus}")
	public User updateUserStatus(@PathVariable Integer id, @PathVariable boolean userStatus) {
		return serv.updateUserStatus(id,userStatus);
	}

}
