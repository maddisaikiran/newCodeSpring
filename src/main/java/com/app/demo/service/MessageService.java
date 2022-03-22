package com.app.demo.service;

import com.app.demo.model.Message;

public interface MessageService {

	Message addMessage (Message message);
	Message sentMessage(Message messageList,Integer id);
	Message sendMessage(Message message);
	
}
