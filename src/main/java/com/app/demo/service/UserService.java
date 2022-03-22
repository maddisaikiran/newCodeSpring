package com.app.demo.service;


import com.app.demo.exception.ValidationException;
import com.app.demo.model.User;

public interface UserService {
	User addUser(User user) throws ValidationException;
	User updateUser(User user) throws ValidationException;
	void deleteUser(int id);
	User getUserByEmailIdAndPassword(String emailId, String password);
	User findByUserEmail(String emailId);
	User getUsersById(int id);
	//User updateUserStatus(Integer id,User user);
	User updateUserStatus(Integer id,boolean userStatus);
	//User updateUserStatus(Integer id);
	

}
