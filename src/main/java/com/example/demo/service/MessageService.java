package com.example.demo.service;

import com.example.demo.model.Message;

public interface MessageService {

	Message addMessage (Message message);
	Message sentMessage(Message messageList,Integer id);
	Message sendMessage(Message message);
	
}
