package com.app.demo.service;

import java.util.List;

import com.app.demo.model.Message;

public interface MessageService {

	Message createMessage(Message message);
	
	List<Message> getMessagesByUserId(Integer friendId);
}
