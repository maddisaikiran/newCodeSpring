package com.app.demo.service;

import java.util.List;

import com.app.demo.model.Liked;

public interface LikedService {
	
	Liked createLike(Liked like);
	
	List<Liked> getUserLikesByMessageById(Integer timeId);
}
