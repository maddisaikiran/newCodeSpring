package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;

public interface SearchUser {
	List<User> getAllUsers();
	
	List<UserDto> getAllFriendsForUser(int requestedUserId);

}
