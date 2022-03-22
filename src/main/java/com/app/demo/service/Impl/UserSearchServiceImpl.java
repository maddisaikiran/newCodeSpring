package com.app.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Friend;
import com.app.demo.model.User;
import com.app.demo.model.UserDto;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.UserSearchService;

@Service
public class UserSearchServiceImpl implements UserSearchService{

	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private FriendServiceImpl friendServiceImpl;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRespository.findAll();
	}

	
	@Override
	public List<UserDto> getAllFriendsForUser(int requestedUserId) {
		// TODO Auto-generated method stub
		List<User> users= userRespository.findAll();
		List<Friend> friends= friendServiceImpl.findFriendsByUserId(requestedUserId);
		users = users.stream().filter(user -> user.getId() != requestedUserId).collect(Collectors.toList());
		for(User user:users) {
			Optional<Friend> friendOptional=friends.stream().filter(friend -> friend.getUser().getId() == user.getId() || friend.getFriend().getId()==user.getId()).findFirst();
			List<Friend> friendsFinal = new ArrayList<>();
			if(friendOptional.isPresent()) {
				friendsFinal.add(friendOptional.get());
				user.setFriend(friendsFinal);
			}
		}
		List<UserDto> userDto=users.stream().map(UserDto::convert).toList();
		return userDto;
	}
}
