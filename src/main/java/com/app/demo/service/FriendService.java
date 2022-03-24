package com.app.demo.service;

import java.util.List;


import com.app.demo.model.Friend;
import com.app.demo.model.User;

public interface FriendService {
	Friend createRequest(Friend friend);
	List<Friend> getAllFriendRequest();
	Friend getFriendById(Integer id);
	
	List<Friend> findFriendsByUserId(Integer id);
	
	List<User> getUserByFriendByOrderStatusById(Integer id);
}
