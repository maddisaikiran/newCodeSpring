package com.app.demo.service;


import com.app.demo.exception.ValidationException;
import com.app.demo.model.User;

public interface UserService {
	User addUser(User user) throws ValidationException;
	User updateUser(User user) throws ValidationException;
	void deleteUser(Integer id);
	User getUserByEmailAndPassword(String email, String password);
	User findByUserEmail(String email);
	User getUserById(Integer id);
	//User updateUserStatus(Integer id,User user);
	User updateUserStatus(Integer id,boolean userStatus);
	//User updateUserStatus(Integer id);
	

}
