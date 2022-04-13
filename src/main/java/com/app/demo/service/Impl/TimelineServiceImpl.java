package com.app.demo.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.app.demo.model.Timeline;
import com.app.demo.model.User;
import com.app.demo.respository.TimelineRepository;
import com.app.demo.service.UserService;
import com.app.demo.service.TimelineService;

@Service
public class TimelineServiceImpl implements TimelineService{

	@Autowired
	TimelineRepository timelineRepository;
	
	@Autowired
	UserService userService;
	
	@Override
	public Timeline addTimeLine(Timeline timeline, Integer userId) {
		User user = userService.getUserById(userId);
		
		timeline.setUser(user);
		timeline.setCount(0);
		return timelineRepository.save(timeline);
	}

	@Override
	public List<Timeline> getAllMyTimeline() {
		return timelineRepository.findAll();
	}

	@Override
	public List<Timeline> getAllMyTimelineById(Integer id) {
		
		User user = userService.getUserById(id);
		List<Timeline> timelines = timelineRepository.findAllByUser(user);
		if(timelines.isEmpty()) {
			throw new ResourceNotFoundException("Timeline not added for user Id: "+id);
		}

		return timelines;
	}

	@Override
	public List<Timeline> getUserByFriendByTimelineById(Integer userId) {
		
		List<Timeline> timelines = timelineRepository.findUserByFriendByTimelineById(userId);
		if(timelines.isEmpty()) {
			throw new ResourceNotFoundException("timeline not found, "+userId);
		}
		return timelines;
	}

	@Override
	public Timeline getTimelineByTimeId(Integer timeId) {
		return timelineRepository.findById(timeId).get();
	}

	@Override
	public void deleteTimeline(Integer timeId) {
		timelineRepository.deleteById(timeId);
	}


}
