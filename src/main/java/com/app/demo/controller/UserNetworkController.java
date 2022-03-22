package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.httpresponse.HttpStatusResponse;
import com.app.demo.model.User;
import com.app.demo.model.UserDto;
import com.app.demo.service.FriendService;
import com.app.demo.service.UserSearchService;
import com.app.demo.util.ResponseUtil;

@RestController
@CrossOrigin
public class UserNetworkController {
	@Autowired
	private UserSearchService serv1;
	
	@Autowired
	private FriendService service;
	
//	@PostMapping("/users/network/")
//	public List<UserDto> getAllFriendsForUser(@RequestBody Integer requestedUserId){
//		return serv1.getAllFriendsForUser(requestedUserId);
//	}
	
	@PostMapping("/users/network/")
	public ResponseEntity <List<UserDto>> getAllFriendsForUser(@RequestBody Integer requestedUserId){
		List<UserDto> u = serv1.getAllFriendsForUser(requestedUserId);
		return new ResponseEntity<List<UserDto>>(u, HttpStatus.CREATED);
		
	}
	
//	@GetMapping("/friends/{friendId}")
//	public List<User> getUserByFriendByOrderStatusById(@PathVariable(value = "friendId") int friendId){
//		return service.getUserByFriendByOrderStatusById(friendId);
//	}
	
	@GetMapping("/friends/{friendId}")
	public ResponseEntity <List<User>> getUserByFriendByOrderStatusById(@PathVariable(value = "friendId") int friendId){
		List<User> u = service.getUserByFriendByOrderStatusById(friendId);
		return new ResponseEntity<List<User>>(u, HttpStatus.CREATED);
	}
}
