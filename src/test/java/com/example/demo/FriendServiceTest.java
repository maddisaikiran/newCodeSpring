package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.demo.SampleApplication;
import com.app.demo.exception.ValidationException;
import com.app.demo.model.Friend;
import com.app.demo.model.FriendStatus;
import com.app.demo.model.User;
import com.app.demo.respository.FriendRepository;
import com.app.demo.respository.FriendStatusRepository;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.FriendService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SampleApplication.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FriendServiceTest {
	
	Friend friendObject;
	User user;
	User friend;
	FriendStatus status;
	
	
	@Autowired
	private FriendService friendService;
	
	@MockBean
	private FriendRepository friendRepository;
	
	@MockBean
	private FriendStatusRepository friendStatusRepository;
	
	@MockBean
	private UserRespository userRespository;
	
	 @BeforeEach
	    void setUp() throws Exception {
	         friendObject = new Friend();
	       //  friendObject.setStatusCode(status.getCode());
	         
	         user = new User();
	         user.setId(1);
	         
	         friend = new User();
	         friend.setId(2);
	         
	         status = new FriendStatus();
	         status.setId(1);
	        // status.getCode(friendObject.setStatusCode("pending"));
	         
	         friendObject.setUser(user);
	         friendObject.setFriend(friend);
	         friendObject.setStatus(status);
	        
	         
	 }
	 
//	 @Test
//	 @Order(1)
//	 public void createRequest() {
//		 when(userRespository.findById(friendObject.getUser().getId()).get()).thenReturn(user);
//		 when(friendStatusRepository.findByStatus(friendObject.getStatusCode())).thenReturn(status);
//		 when(userRespository.findById(friendObject.getFriend().getId()).get()).thenReturn(friend);
//		 when(friendRepository.save(friendObject)).thenReturn(friendObject);
//		 assertEquals(friendObject, friendService.createRequest(friendObject));
//	    }

}
