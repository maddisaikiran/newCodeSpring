package com.app.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.httpresponse.HttpStatusResponse;
import com.app.demo.model.Friend;
import com.app.demo.service.FriendService;
import com.app.demo.util.ResponseUtil;

@RestController
@CrossOrigin
public class FriendController {
	@Autowired
	private FriendService service;
	
//	@PostMapping("/friends/createrequest")
//	public Friend createRequest(@RequestBody Friend friend) {
//		return service.createRequest(friend);
//	}
	@PostMapping("/friends/createrequest")
	public ResponseEntity<HttpStatusResponse> createRequest(@Valid @RequestBody Friend friend) {
		Friend f = service.createRequest(friend);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), f, "Friend Request sent");
		
	}
	
	
	@GetMapping("/friends")
	public List<Friend> getAllFriendRequests(){
		return service.getAllFriendRequests();
	}

}
