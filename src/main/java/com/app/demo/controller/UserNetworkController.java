package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.constants.Constants;
import com.app.demo.httpresponse.HttpGetStatusResponse;

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
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), userDtos,Constants.FRIEND_REQUEST_SEND);
		
	}
	
	@GetMapping("/friends/{friendId}")
	public ResponseEntity <HttpGetStatusResponse> getUserByFriendByOrderStatusById(@PathVariable(value = "friendId") int friendId){
		List<User> users = service.getUserByFriendByOrderStatusById(friendId);
		if(CollectionUtils.isEmpty(users)) {
			return ResponseUtil.prepareErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.FRIENDS_NOT_FOUND);
		}
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), users,Constants.MY_FRIENDS_FOUND);
	}
}
