package com.app.demo.service;

import java.util.List;

import com.app.demo.model.Friend;
import com.app.demo.model.Timeline;
import com.app.demo.model.User;

public interface TimelineService {
	
	Timeline addTimeLines(Timeline timeline);
	
	
	
//	Timeline addTimeLine(Timeline timeline,Integer id);
	Timeline addTimeLine(Timeline timeline,Integer userId);
	
	  List<Timeline> getAllMyTimelines();
	  
	  List<Timeline> getAllMyTimelinesById(Integer id);
	  
	  Timeline getTimelineByTimeId(Integer timeId);
	  
	  Timeline addUserToTimeline(Integer id);
	  
	  
	  List<Timeline> getUserByFriendByTimelineById(Integer userId);

}
