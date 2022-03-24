package com.app.demo.service.Impl;

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
		// TODO Auto-generated method stub
		FriendStatus friendStatus= friendStatusRepository.findByStatus(friend.getStatusCode());
		friend.setStatus(friendStatus);
		//new code
		//friend.setUser(userRespository.findById(friend.getUser().getId()).get());
		//new code
		friend.setFriend(userRespository.findById(friend.getFriend().getId()).get());
		return friendRepository.save(friend);
	}

	@Override
	public List<Friend> getAllFriendRequest() {
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
