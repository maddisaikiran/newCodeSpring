package com.app.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.constants.Constants;
import com.app.demo.httpresponse.HttpGetStatusResponse;
import com.app.demo.httpresponse.HttpStatusResponse;
import com.app.demo.model.Message;
import com.app.demo.service.MessageService;
import com.app.demo.util.ResponseUtil;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@PostMapping("")
	public ResponseEntity<HttpStatusResponse> createMessage(@RequestBody Message message) {
		Message createMessage = messageService.createMessage(message);
		return ResponseUtil.prepareSuccessResponse(HttpStatus.CREATED.value(), createMessage, Constants.MESSAGE_CREATE);
	}
	
	@GetMapping("/{friendId}")
	public ResponseEntity<HttpGetStatusResponse> getMessagesByUserId(@PathVariable(value="friendId") Integer friendId){
		List<Message> messages = messageService.getMessagesByUserId(friendId);
		return ResponseUtil.prepareHttpResponse(HttpStatus.OK.value(), messages, Constants.MESSAGE_FOUND);
	}
}