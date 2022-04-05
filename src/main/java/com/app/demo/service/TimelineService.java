package com.app.demo.service;

import java.util.List;

import com.app.demo.exception.ValidationException;
import com.app.demo.model.Timeline;



public interface TimelineService {
	

	Timeline addTimeLine(Timeline timeline,Integer userId) throws ValidationException;
	
	  Timeline getTimelineByTimeId(Integer timeId);
	
	  List<Timeline> getAllMyTimeline();
	  
	  List<Timeline> getAllMyTimelineById(Integer id);
	  
	  
	  List<Timeline> getUserByFriendByTimelineById(Integer userId);

	  void deleteTimeline(Integer timeId);
}
