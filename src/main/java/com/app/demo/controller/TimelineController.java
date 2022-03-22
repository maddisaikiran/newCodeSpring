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
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.httpresponse.HttpStatusResponse;
import com.app.demo.model.Timeline;

import com.app.demo.service.TimelineService;
import com.app.demo.util.ResponseUtil;

@RestController
@CrossOrigin
public class TimelineController {

	
	@Autowired
	TimelineService service;
	
//	@PostMapping("/time/user/{userId}")
//	public Timeline addTimeLine(@RequestBody Timeline timeline,@PathVariable Integer userId) {
//		
//		return service.addTimeLine(timeline,userId);
//	}
	@PostMapping("/time/user/{userId}")
	public ResponseEntity<HttpStatusResponse> addTimeLine(@RequestBody Timeline timeline,@PathVariable Integer userId) {
		Timeline t = null;
		t = service.addTimeLine(timeline, userId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), t, "Timeline Added Sucessfully");
	}
	
	@GetMapping("/timelines")
	public List<Timeline> getAllMyTimelines() {
		return service.getAllMyTimelines();
	}
	
	@GetMapping("/timelines/pos/{id}")
	public ResponseEntity <List<Timeline>> getAllMyTimelinesById(@PathVariable Integer id){
	List<Timeline> time = service.getAllMyTimelinesById(id);
	return new ResponseEntity<List<Timeline>>(time, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/time/pos/{userId}")
	public ResponseEntity <List<Timeline>> getUserByFriendByTimelineById(@PathVariable(value = "userId") Integer userId){
		List<Timeline> time = service.getUserByFriendByTimelineById(userId);
		return new ResponseEntity<List<Timeline>>(time,HttpStatus.CREATED);
	}
	
}
