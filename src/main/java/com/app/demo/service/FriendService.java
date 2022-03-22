package com.app.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.demo.model.Friend;
import com.app.demo.model.User;

public interface FriendService {
	Friend createRequest(Friend friend);
	//Friend updateRequest(Friend friend, int id);
	List<Friend> getAllFriendRequests();
	Friend getFriendById(Integer id);
	
	List<Friend> findFriendsByUserId(Integer id);
	
	List<User> getUserByFriendByOrderStatusById(Integer id);
}
