package com.app.demo.service.Impl;



import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.demo.exception.ValidationException;
import com.app.demo.model.User;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	

	@Autowired
	private UserRespository userRespository;
	
	
	@Override
	public User addUser(User user) throws ValidationException {
		// TODO Auto-generated method stub
		validateUser(user);
		return userRespository.save(user);
	}

	@Override
	public User updateUser(User user) throws ValidationException{
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
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return userRespository.findById(id).get();
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRespository.findByEmailAndPassword(email, password);
	}
	
	private void validateUser(User user) throws ValidationException {
		if(Objects.isNull(user.getEmail())){
			throw new ValidationException("Email id should be mandatory");
		}
		
		if(Objects.isNull(user.getPassword()) || user.getPassword().trim().equals("")) {
			throw new ValidationException("Password should be mandatory");
		}
		if(Objects.isNull(user.getMobile())) {
			throw new ValidationException("Mobile should be mandatory");
		}
		if(Objects.isNull(user.getFullName())) {
			throw new ValidationException("FullName should be mandatory");
		}
	}

	@Override	
	public User updateUserStatus(Integer id,boolean userStatus) {
		
		
		User user = userRespository.findById(id).get();
	     user.setUserStatus(userStatus);
		return userRespository.save(user);
	}

	

}
