package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;
import com.example.demo.service.CartService;

@RestController
@CrossOrigin
public class CartController {
	
	@Autowired
	CartService service;
	
	@PostMapping("/cart/user/{id}/time/{timeId}")
	public Cart addTimelineAndUserToCart(@PathVariable  Integer timeId,@PathVariable Integer id) {
		return service.addTimelineAndUserToCart(timeId, id);
	}
}
