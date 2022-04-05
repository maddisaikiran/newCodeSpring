package com.app.demo.service.Impl;

import java.util.List;
import java.util.Optional;

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
		// TODO Auto-generated method stub
		message.setFriend(userRespository.findById(message.getFriend().getId()).get());
		
		return messageRepository.save(message);
	}

	@Override
	public List<Message> getMessagesByUserId(Integer friendId) {
		// TODO Auto-generated method stub
		 Optional<List<Message>> messageOptional = Optional.of(messageRepository.findMessagesByUserId(friendId));
			return messageOptional.isPresent() ? messageOptional.get() : null;
	}
	

}
