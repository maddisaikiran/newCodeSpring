package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Timeline;

public interface TimelineService {
	
	Timeline addTimeLines(Timeline timeline);
	
	//Timeline addTimeLine(Integer id, int timeId);
	
	Timeline addTimeLine(Timeline timeline,Integer id);
	
	
	  List<Timeline> getAllMyTimelines();
	  
	  List<Timeline> getAllMyTimelinesById(Integer id);
	  
	  Timeline getTimelineByTimeId(Integer timeId);
	  
	  Timeline addUserToTimeline(Integer id);

}
