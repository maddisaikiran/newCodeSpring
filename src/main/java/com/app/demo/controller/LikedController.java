package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.constants.Constants;
import com.app.demo.httpresponse.HttpStatusResponse;
import com.app.demo.model.Liked;
import com.app.demo.service.LikedService;
import com.app.demo.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/like")
public class LikedController {
	
	@Autowired
	LikedService likeService;
	
	@PostMapping("")
	public ResponseEntity<HttpStatusResponse> createLike(@RequestBody Liked like) {
		Liked addLike = likeService.createLike(like);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), addLike, Constants.MESSAGE_LIKE);
	}
	
	
	@GetMapping("/{timeId}")
	public ResponseEntity<HttpStatusResponse> getUserLikesByMessageById(@PathVariable(value = "timeId") Integer timeId) {
		List<Liked> likes = likeService.getUserLikesByMessageById(timeId);
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), likes, Constants.MESSAGE_LIKES);
	}
	
}
