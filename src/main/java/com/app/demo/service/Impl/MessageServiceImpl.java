package com.app.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.exception.ResourceNotFoundException;
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

		 List<Message> messages = messageRepository.findMessagesByFriendId(friendId);
		 if(messages.isEmpty()) {
			 throw new ResourceNotFoundException("message not found");
		 }
			return messages;
	}

	@Override
	public List<Message> getMessagesByUserId(Integer userId) {
		 List<Message> messages = messageRepository.findMessagesByUserId(userId);
//		 if(messages.isEmpty()) {
//			 throw new ResourceNotFoundException("message not found");
//		 }
			return messages;
	}
	

}
