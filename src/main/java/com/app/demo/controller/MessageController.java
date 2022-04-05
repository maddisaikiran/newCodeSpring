package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.model.Message;
import com.app.demo.service.MessageService;

@RestController
@CrossOrigin
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@PostMapping("/message")
	public Message createMessage(@RequestBody Message message) {
		return messageService.createMessage(message);
	}
	
	@GetMapping("/message/{friendId}")
	public List<Message> getMessagesByUserId(@PathVariable(value="friendId") Integer friendId){
		return messageService.getMessagesByUserId(friendId);
	}
}
