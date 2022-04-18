package com.app.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.constants.Constants;
import com.app.demo.constants.UrlConstants;
import com.app.demo.httpresponse.HttpGetStatusResponse;
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
	public ResponseEntity<HttpStatusResponse> addTimeLine(@Valid @RequestBody Timeline timeline,@PathVariable Integer userId) {
		Timeline addTimeline = timelineService.addTimeLine(timeline, userId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), addTimeline, Constants.TIMELINE_ADDED_SUCCESS);
	}
	
	@GetMapping
	public List<Timeline> getAllMyTimeline() {
		return timelineService.getAllMyTimeline();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity <HttpGetStatusResponse> getAllMyTimelineById(@PathVariable Integer id){
	List<Timeline> timelines = timelineService.getAllMyTimelineById(id);
	if(CollectionUtils.isEmpty(timelines)) {
		return ResponseUtil.prepareTimelinesNotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.MY_TIMELINES_NOT_FOUND);
	}
	return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), timelines,Constants.MY_TIMELINE_FOUND );
	}

	@GetMapping("/friend/{userId}")
	public ResponseEntity <HttpGetStatusResponse> getUserByFriendByTimelineById(@PathVariable(value = "userId") Integer userId){
        List<Timeline> timelines = timelineService.getUserByFriendByTimelineById(userId);
        if(CollectionUtils.isEmpty(timelines)) {
    		return ResponseUtil.prepareTimelinesNotFound(HttpStatus.INTERNAL_SERVER_ERROR.value(), Constants.TIMELINES_NOT_FOUND);
    	}
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(),timelines,Constants.ALL_TIMELINE_FOUND);
}
	
	@GetMapping(UrlConstants.GET_TIMEID)
	public ResponseEntity<HttpStatusResponse>  getTimelineByTimeId(@PathVariable Integer timeId) {
		Timeline timeline = timelineService.getTimelineByTimeId(timeId);
		
		return ResponseUtil.prepareSuccessResponse(HttpStatus.OK.value(), timeline, Constants.ALL_TIMELINE_FOUND);
	
	}
	
	@DeleteMapping(UrlConstants.GET_TIMEID)
	public ResponseEntity<HttpStatusResponse> deleteTimeline(@PathVariable Integer timeId) {
		timelineService.deleteTimeline(timeId);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.NO_CONTENT.value(), timeId, Constants.TIMELINE_DELETE_SUCCESS);
	}
	
}
