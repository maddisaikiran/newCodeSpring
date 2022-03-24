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

import com.app.demo.constants.Constants;
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
	private UserSearchService userSearchService;
	
	@Autowired
	private FriendService service;
	
	@PostMapping("/users/network/")
	public ResponseEntity<HttpStatusResponse> getAllFriendForUser(@RequestBody Integer requestedUserId){
		List<UserDto> userDtos = userSearchService.getAllFriendForUser(requestedUserId);
		return ResponseUtil.prepareHttpResponse(HttpStatus.CREATED.value(), userDtos,Constants.MESSAGE_FRIEND_REQUEST);
		
	}
	
	@GetMapping("/friends/{friendId}")
	public ResponseEntity <HttpStatusResponse> getUserByFriendByOrderStatusById(@PathVariable(value = "friendId") int friendId){
		List<User> users = service.getUserByFriendByOrderStatusById(friendId);
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), users,Constants.MESSAGE_FRIEND_FOUND);
	}
}
