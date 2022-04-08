package com.app.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.exception.UserNotFoundException;
import com.app.demo.model.User;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	

	@Autowired
	private UserRespository userRespository;
	
	
	@Override
	public User addUser(User user)  {
		// TODO Auto-generated method stub
		
		return userRespository.save(user);
	}

	@Override
	public User updateUser(User user){
		// TODO Auto-generated method stub
		return userRespository.save(user);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userRespository.deleteById(id);
	}

	@Override
	public User findByUserEmail(String email) {
		// TODO Auto-generated method stub
		User c = new User();
		c = userRespository.findByEmail(email);
		return c;
	}

	@Override
	public User getUserById(Integer id){
		// TODO Auto-generated method stub
		User user = userRespository.findById(id).get();
		if(user == null) {
			throw new UserNotFoundException("user not found");
		}
		return user;
		
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRespository.findByEmailAndPassword(email, password);
	}

	@Override	
	public User updateUserStatus(Integer id,boolean userStatus) {
		
		
		User user = userRespository.findById(id).get();
	     user.setUserStatus(userStatus);
		return userRespository.save(user);
	}

	

}
