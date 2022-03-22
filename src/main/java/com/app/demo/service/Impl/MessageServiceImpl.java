package com.app.demo.service.Impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.model.Message;
import com.app.demo.model.User;
import com.app.demo.respository.MessageRepository;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.UserService;
import com.app.demo.service.MessageService;



@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageRepository repository;
	
	@Autowired
	UserRespository userRepository;
	
	@Override
	public Message addMessage(Message message) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Autowired
	UserService userService;

	@Override
	public Message sentMessage(Message messageList,Integer id) {
		
		//List <Message> messageList = repository.findByUserId(id);
		
		
		//User user = new User();
		User user = userService.getUsersById(id);
		messageList.setUser(user);
		
		//user.setMessageList(messageList);
//		messageList.setId(id);
//		messageList.setMessage(message);
//		messageList.setUserName(message);
		//repository.save(messageList);
	     return  repository.save(messageList);
		
	}

	@Override
	public Message sendMessage(Message message) {
		// TODO Auto-generated method stub
		
		//Message messageList = new Message();
		message.setMgs(message.getMgs());
		//messageList.setUserName(userName);
		//messageList.getUser()
		
		message.setMessage(userRepository.findById(message.getMessage().getId()).get());
		
		
		return repository.save(message);
	}

	
}
