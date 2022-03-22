package com.app.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Friend;
import com.app.demo.model.Timeline;
import com.app.demo.model.User;
import com.app.demo.respository.TimelineRepository;
import com.app.demo.service.UserService;
import com.app.demo.service.TimelineService;

@Service
public class TimelineServiceImpl implements TimelineService{

	@Autowired
	TimelineRepository repository;
	
	@Autowired
	UserService userService;
	
	@Override
	//public Timeline addTimeLine(Integer id, int timeId) {
	public Timeline addTimeLine(Timeline timeline,Integer userId) {
		
		User user = userService.getUsersById(userId);
		
		timeline.setUser(user);
		return repository.save(timeline);
	}

	@Override
	public List<Timeline> getAllMyTimelines() {
		// TODO Auto-generated method stub
		
		return repository.findAll();
	}

	@Override
	public List<Timeline> getAllMyTimelinesById(Integer id) {
		// TODO Auto-generated method stub
		
		
		User user = userService.getUsersById(id);
		List<Timeline> mytimelines = repository.findAllByUser(user);
		 // List<Timeline> mytimelines = new ArrayList<>();
		return mytimelines;
	//	return null;
	}

	@Override
	public Timeline getTimelineByTimeId(Integer timeId) {
		// TODO Auto-generated method stub
		return repository.findById(timeId).get();
	}

	@Override
	public Timeline addTimeLines(Timeline timeline) {
		// TODO Auto-generated method stub
		return repository.save(timeline);
	}

	@Override
	public Timeline addUserToTimeline(Integer id) {
		// TODO Auto-generated method stub
//		Timeline time = new Timeline();
//		time.setTimeLineName(time.getTimeLineName());
		
		User user = userService.getUsersById(id);
		
		Timeline timeline = new Timeline();
		timeline.setUser(user);
//		
		
//		timeline.setTimeLineName(timeline.getTimeLineName());
//		timeline.setMessage(timeline.getMessage());
		return repository.save(timeline);
	}

	@Override
	public List<Timeline> getUserByFriendByTimelineById(Integer userId) {
		
		//User user = userService.getUsersById(id);
		 Optional<List<Timeline>> usersOptional = Optional.of(repository.findUserByFriendByTimelineById(userId));
		return usersOptional.isPresent() ? usersOptional.get() : null;
	}

//	@Override
//	public Timeline addTimeLine(Timeline timeline) {
//		// TODO Auto-generated method stub
//		User user = userService.getUsersById(id);
//		Timeline timeline = new Timeline();
//		timeline.setUser(user);
//		return repository.save(user);
//	}
	
	

}
