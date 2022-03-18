package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;

@RestController
@CrossOrigin
public class MessageController {
	
	@Autowired
	MessageService service;
	
	@PostMapping("/message/{id}")
	public Message sentMessage(@RequestBody Message messageList,@PathVariable Integer id) {
		return service.sentMessage(messageList, id);
	}

	@PostMapping("message/create")
	public Message sendMessage(@RequestBody Message message) {
		return service.sendMessage(message);
	}
}
