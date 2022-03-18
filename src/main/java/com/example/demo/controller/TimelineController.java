package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Timeline;
import com.example.demo.service.TimelineService;

@RestController
@CrossOrigin
public class TimelineController {

	
	@Autowired
	TimelineService service;
	
	
	@PostMapping("/time/user/{id}")
	//public Timeline addTimeLine(@PathVariable Integer id, @PathVariable int timeId) {
	
	public Timeline addTimeLine(@RequestBody Timeline timeline,@PathVariable Integer id) {
	// TODO Auto-generated method stub
		return service.addTimeLine(timeline,id);
	}
	
//	@PostMapping("/timeline/user")
//	public Timeline addTimeLine(@RequestBody Timeline timeLine) {
////		// TODO Auto-generated method stub
//		return service.addTimeLine(timeLine);
//	}
	
	@PostMapping("/timelines/user/{id}")
	public Timeline addUserToTimeline(@PathVariable Integer id) {
		return service.addUserToTimeline(id);
	}
	

	
	@GetMapping("/timelines")
	public List<Timeline> getAllMyTimelines() {
		return service.getAllMyTimelines();
	}
	
	@GetMapping("/timelines/pos/{id}")
	public List<Timeline> getAllMyTimelinesById(@PathVariable Integer id){
		return service.getAllMyTimelinesById(id);
	}
	
	@PostMapping("/timeline")
	public Timeline addTimelines(@RequestBody Timeline timeline) {
		return service.addTimeLines(timeline);
	}
	
}
