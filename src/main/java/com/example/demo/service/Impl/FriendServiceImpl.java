package com.example.demo.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Friend;
import com.example.demo.model.FriendStatus;
import com.example.demo.model.User;
import com.example.demo.respository.FriendRepository;
import com.example.demo.respository.FriendStatusRepository;
import com.example.demo.respository.UserRespository;
import com.example.demo.service.FriendService;

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
		// TODO Auto-generated method stub
		FriendStatus friendStatus= friendStatusRepository.findByCode(friend.getStatusCode());
		friend.setStatus(friendStatus);
		friend.setFriend(userRespository.findById(friend.getFriend().getId()).get());
		return friendRepository.save(friend);
	}

	@Override
	public List<Friend> getAllFriendRequests() {
		// TODO Auto-generated method stub
		return friendRepository.findAll();
	}

	@Override
	public Friend getFriendById(Integer id) {
		// TODO Auto-generated method stub
		return friendRepository.findById(id).get();
	}
	
	

//	@Override
//	public Friend updateRequest(Friend friend) {
//		// TODO Auto-generated method stub
//		return friendRepository.save(friend);
//	}



//	@Override
//	public Friend updateRequest(int id) {
//		// TODO Auto-generated method stub
//		return friendRepository.findById(id).get();
//	}



//	@Override
//	public Friend updateRequest(Friend friend, int id) {
//		// TODO Auto-generated method stub
//		Friend friends = friendRepository.findById(id).get();
//		Friend updateRequest = friendRespository.save(friends);
//		return updateRequest;
//	}
	
	@Override
	public List<Friend> findFriendsByUserId(Integer id) {
		// TODO Auto-generated method stub
		return friendRepository.findFriendsByUserId(id);
	}

	@Override
	public List<User> getUserByFriendByOrderStatusById(Integer id) {
		// TODO Auto-generated method stub
		Optional<List<User>> usersOptional = Optional.of(userRespository.findUserByFriendByOrderStatusById(id));
		return usersOptional.isPresent() ? usersOptional.get() : null;
	}
	

}
