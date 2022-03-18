package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.SearchUser;

@RestController
@CrossOrigin
public class UserSearch {
	@Autowired
	private SearchUser serv1;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return serv1.getAllUsers();
	}
}
