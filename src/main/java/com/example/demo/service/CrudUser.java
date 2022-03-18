package com.example.demo.service;


import com.example.demo.exception.ValidationException;
import com.example.demo.model.User;

public interface CrudUser {
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
