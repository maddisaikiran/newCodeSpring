package com.app.demo.service;

import java.util.List;

import com.app.demo.model.Message;

public interface MessageService {

	Message createMessage(Message message);
	
	List<Message> getMessagesByFriendId(Integer friendId);
	
	List<Message> getMessagesByUserId(Integer userId);
}
