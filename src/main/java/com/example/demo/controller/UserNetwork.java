package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Friend;
import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.service.FriendService;
import com.example.demo.service.SearchUser;

@RestController
@CrossOrigin
public class UserNetwork {
	@Autowired
	private SearchUser serv1;
	
	@Autowired
	private FriendService service;
	
	@PostMapping("/users/network/")
	public List<UserDto> getAllFriendsForUser(@RequestBody int requestedUserId){
		return serv1.getAllFriendsForUser(requestedUserId);
	}
	
	@GetMapping("/friends/{friendId}")
	public List<User> getUserByFriendByOrderStatusById(@PathVariable(value = "friendId") int friendId){
		return service.getUserByFriendByOrderStatusById(friendId);
	}
}
