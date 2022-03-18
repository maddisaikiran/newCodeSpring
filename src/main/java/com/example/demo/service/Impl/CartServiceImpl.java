package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;
import com.example.demo.model.Timeline;
import com.example.demo.model.User;
import com.example.demo.respository.CartRepository;
import com.example.demo.service.CartService;
import com.example.demo.service.CrudUser;
import com.example.demo.service.TimelineService;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartRepository repository;
	
	@Autowired
	private CrudUser service;
	
	@Autowired
	private TimelineService timeservice;
	
	@Override
	public Cart addTimelineAndUserToCart(Integer timeId, Integer id) {
		// TODO Auto-generated method stub
		User user = service.getUsersById(id);
		Timeline timeline = timeservice.getTimelineByTimeId(timeId);
		Cart cart = new Cart();
		cart.setUser(user);
		cart.setTimeline(timeline);
		
		return repository.save(cart);
	}

}
