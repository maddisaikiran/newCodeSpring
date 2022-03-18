package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Friend;

import com.example.demo.service.FriendService;

@RestController
@CrossOrigin
public class FriendController {
	@Autowired
	private FriendService service;
	
	@PostMapping("/friends/createrequest")
	public Friend createRequest(@RequestBody Friend friend) {
		return service.createRequest(friend);
	}
	
//	@PutMapping("/friends/updaterequest/{id}")
//	public Friend updateRequest(@PathVariable int id, @RequestBody Friend friend) {
////		Friend friend = service.updateRequest(id);
//		return service.updateRequest(friend, id);
//		
//		
//	}
	
//	@GetMapping("/friends/{id}")
//	public Friend getFriendById(@PathVariable int id) {
//		return service.getFriendById(id);
//	}
	
	
	@GetMapping("/friends")
	public List<Friend> getAllFriendRequests(){
		return service.getAllFriendRequests();
	}

}
