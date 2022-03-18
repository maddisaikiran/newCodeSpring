package com.example.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Timeline;
import com.example.demo.model.User;
import com.example.demo.respository.TimelineRepository;
import com.example.demo.service.CrudUser;
import com.example.demo.service.TimelineService;

@Service
public class TimelineServiceImpl implements TimelineService{

	@Autowired
	TimelineRepository repository;
	
	@Autowired
	CrudUser userService;
	
	@Override
	//public Timeline addTimeLine(Integer id, int timeId) {
	public Timeline addTimeLine(Timeline timeline,Integer id) {
		
		User user = userService.getUsersById(id);
		
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

//	@Override
//	public Timeline addTimeLine(Timeline timeline) {
//		// TODO Auto-generated method stub
//		User user = userService.getUsersById(id);
//		Timeline timeline = new Timeline();
//		timeline.setUser(user);
//		return repository.save(user);
//	}
	
	

}
