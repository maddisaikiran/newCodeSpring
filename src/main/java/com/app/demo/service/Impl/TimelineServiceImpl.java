package com.app.demo.service.Impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ValidationException;
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
	public Timeline addTimeLine(Timeline timeline, Integer userId) throws ValidationException {
		User user = userService.getUserById(userId);
		timeline.setUser(user);
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
		return timelines;
	}

	@Override
	public List<Timeline> getUserByFriendByTimelineById(Integer userId) {
		 Optional<List<Timeline>> usersOptional = Optional.of(timelineRepository.findUserByFriendByTimelineById(userId));
		return usersOptional.isPresent() ? usersOptional.get() : null;
	}

	

	

}
