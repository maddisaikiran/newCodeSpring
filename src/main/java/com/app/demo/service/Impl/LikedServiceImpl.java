package com.app.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
import com.app.demo.model.Liked;
import com.app.demo.respository.LikedRepository;
import com.app.demo.respository.TimelineRepository;
import com.app.demo.service.LikedService;


@Service
public class LikedServiceImpl implements LikedService{
	
	@Autowired
	LikedRepository likeRepository ;
	
	@Autowired
	TimelineRepository timelineRepository;
	
	@Override
	public Liked createLike(Liked like) {
		// TODO Auto-generated method stub
		like.setTimeline(timelineRepository.findById(like.getTimeline().getTimeId()).get());
		return likeRepository.save(like);
	}

	@Override
	public List<Liked> getUserLikesByMessageById(Integer timeId) {
		// TODO Auto-generated method stub
		
		List<Liked> likes = likeRepository.findUserLikesByMessageById(timeId);
		if(likes.size() == 0) {
			throw new ResourceNotFoundException("like not found");
		}
		return likes;
	}
	

}
