package com.app.demo.service;

import java.util.List;

import com.app.demo.model.User;
import com.app.demo.model.UserDto;

public interface UserSearchService {
	List<User> getAllUsers();
	
	List<UserDto> getAllFriendsForUser(int requestedUserId);

}
