package com.app.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Message;
import com.app.demo.respository.MessageRepository;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Override
	public Message createMessage(Message message) {

		message.setFriend(userRespository.findById(message.getFriend().getId()).get());
		
		return messageRepository.save(message);
	}

	@Override
	public List<Message> getMessagesByFriendId(Integer friendId) {

		return messageRepository.findMessagesByFriendId(friendId);
			
	}

	@Override
	public List<Message> getMessagesByUserId(Integer userId) {
		
	return messageRepository.findMessagesByUserId(userId);		
	}
	

}
