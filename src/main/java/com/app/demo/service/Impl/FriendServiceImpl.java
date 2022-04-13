package com.app.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Friend;
import com.app.demo.model.FriendStatus;
import com.app.demo.model.User;
import com.app.demo.respository.FriendRepository;
import com.app.demo.respository.FriendStatusRepository;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.FriendService;

@Service
public class FriendServiceImpl implements FriendService{

	@Autowired
	private FriendRepository friendRepository;
	
	@Autowired
	private FriendStatusRepository friendStatusRepository;
	
	@Autowired
	private UserRespository userRespository;
	
	@Override
	public Friend createRequest(Friend friend) {

		FriendStatus friendStatus= friendStatusRepository.findByStatus(friend.getStatusCode());
		friend.setStatus(friendStatus);
		friend.setFriend(userRespository.findById(friend.getFriend().getId()).get());
		return friendRepository.save(friend);
	}

	@Override
	public List<Friend> getAllFriendRequest() {

		return friendRepository.findAll();
	}

	@Override
	public Friend getFriendById(Integer id) {

		return friendRepository.findById(id).get();
	}
	
	
	@Override
	public List<Friend> findFriendsByUserId(Integer id) {

		return friendRepository.findFriendsByUserId(id);
	}

	@Override
	public List<User> getUserByFriendByOrderStatusById(Integer id) {
		Optional<List<User>> usersOptional = Optional.of(userRespository.findUserByFriendByOrderStatusById(id));
		if(usersOptional.isPresent()) {
			return usersOptional.get();
		}else {
			return null;
		}
		//return usersOptional.isPresent() ? usersOptional.get() : null;
	}
	

}
