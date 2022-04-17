package com.app.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.constants.Constants;
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
<<<<<<< Updated upstream
		
=======
>>>>>>> Stashed changes
		return userRespository.save(user);
	}

	@Override
	public User updateUser(User user){
		return userRespository.save(user);
	}

	@Override
	public void deleteUser(Integer id) {

		userRespository.deleteById(id);
	}

	@Override
	public User findByUserEmail(String email) {
		
		return userRespository.findByEmail(email);
		 
	}

	@Override
	public User getUserById(Integer id){
		User user = userRespository.findById(id).get();
		if(user == null) {
			throw new UserNotFoundException(Constants.USER_NOT_FOUND);
		}
		return user;
		
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		return userRespository.findByEmailAndPassword(email, password);
	}

	@Override	
	public User updateUserStatus(Integer id,boolean userStatus) {
		
		
		User user = userRespository.findById(id).get();
		if(user == null) {
			throw new UserNotFoundException(Constants.USER_NOT_FOUND);
		}
	     user.setUserStatus(userStatus);
		return userRespository.save(user);
	}

	

}
