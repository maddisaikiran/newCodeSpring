package com.app.demo.service;

import java.util.List;

import com.app.demo.model.Like;

public interface LikeService {
	
	Like createLike(Like like);
	
	List<Like> getUserLikesByMessageById(Integer timeId);
	
}
