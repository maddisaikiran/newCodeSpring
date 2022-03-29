package com.example.demo;

import org.junit.jupiter.api.TestMethodOrder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.app.demo.SampleApplication;
import com.app.demo.model.Friend;
import com.app.demo.model.FriendStatus;
import com.app.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@ContextConfiguration(classes = SampleApplication.class)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class FriendControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	Friend friendObject;
	
	User user;
	
	User friend;
	
	FriendStatus status;
	

	
	@BeforeEach
	void setUp() throws Exception {
		friendObject = new Friend();
	    friendObject.setStatusCode(status.getCode());
	    friendObject.getStatusCode();
		
		
		user = new User();
		user.setId(1);
		
		friend = new User();
		friend.setId(8);
		
	}
	
//	@Test
//	@Order(1)
//	public void createRequestControllertest() throws Exception{
//		
//		mvc.perform(post("/friends/createrequest").contentType(MediaType.APPLICATION_JSON).content(asJsonString(friendObject)))
//		.andExpect(status().isOk());
//	}
//	
//	
//	
//	public static String asJsonString(final Object obj) {
//		try {
//			return new ObjectMapper().writeValueAsString(obj);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
	//}
	
	

}
