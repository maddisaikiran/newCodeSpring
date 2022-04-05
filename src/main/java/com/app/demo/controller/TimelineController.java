package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.constants.Constants;
import com.app.demo.exception.ValidationException;
import com.app.demo.httpresponse.HttpStatusResponse;
import com.app.demo.model.Timeline;

import com.app.demo.service.TimelineService;
import com.app.demo.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/timeline")
public class TimelineController {

	
	@Autowired
	TimelineService timelineService;
	
	@PostMapping("/user/{userId}")
	public ResponseEntity<HttpStatusResponse> addTimeLine(@RequestBody Timeline timeline,@PathVariable Integer userId) throws ValidationException {
		Timeline addTimeline = timelineService.addTimeLine(timeline, userId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), addTimeline, Constants.MESSAGE_TIMELINE_ADDED);
	}
	
	@GetMapping("")
	public List<Timeline> getAllMyTimeline() {
		return timelineService.getAllMyTimeline();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity <HttpStatusResponse> getAllMyTimelineById(@PathVariable Integer id){
	List<Timeline> timelines = timelineService.getAllMyTimelineById(id);
	return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), timelines,Constants.MESSAGE_TIMELINE_FOUND );
	}

	@GetMapping("/friend/{userId}")
	public ResponseEntity <HttpStatusResponse> getUserByFriendByTimelineById(@PathVariable(value = "userId") Integer userId){
        List<Timeline> timelines = timelineService.getUserByFriendByTimelineById(userId);
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(),timelines,Constants.MESSAGE_TIMELINE_FOUND);
}
	
	@GetMapping("/{timeId}")
	public ResponseEntity<HttpStatusResponse>  getTimelineByTimeId(@PathVariable Integer timeId) {
		Timeline timeline = timelineService.getTimelineByTimeId(timeId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.OK.value(), timeline, Constants.MESSAGE_TIMELINE_FOUND);
	
	}
	
	@DeleteMapping("/{timeId}")
	public ResponseEntity<HttpStatusResponse> deleteTimeline(@PathVariable Integer timeId) {
		timelineService.deleteTimeline(timeId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.NO_CONTENT.value(), timeId, Constants.MESSAGE_TIMELINE_DELETE);
	}
	
}
