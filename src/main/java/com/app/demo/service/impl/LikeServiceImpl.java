package com.app.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.app.demo.model.Like;
import com.app.demo.respository.LikeRepository;
import com.app.demo.respository.TimelineRepository;
import com.app.demo.service.LikeService;


@Service
public class LikeServiceImpl implements LikeService{
	
	@Autowired
	LikeRepository likeRepository ;
	
	@Autowired
	TimelineRepository timelineRepository;
	
	@Override
	public Like createLike(Like like) {
		like.setTimeline(timelineRepository.findById(like.getTimeline().getTimeId()).get());
		return likeRepository.save(like);
	}

	@Override
	public List<Like> getUserLikesByMessageById(Integer timeId) {
		
		List<Like> likes = likeRepository.findUserLikesByMessageById(timeId);
		if(likes.isEmpty()) {
			throw new ResourceNotFoundException("like not found");
		}
		return likes;
	}

	

}
