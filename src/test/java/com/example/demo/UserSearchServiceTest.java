package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.demo.SampleApplication;
import com.app.demo.model.Friend;
import com.app.demo.model.Timeline;
import com.app.demo.model.User;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.FriendService;
import com.app.demo.service.UserSearchService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SampleApplication.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserSearchServiceTest {

	@Autowired
	UserSearchService userSearchService;
	
	@Autowired
	FriendService friendService;
	
	@MockBean
	UserRespository userRespository;
	
	User user;
	
	Friend friend;
	
	@BeforeEach
    void setUp() throws Exception {
		friend = new Friend();
		user = new User();
		user.setId(2);
		friend.setUser(user);
	}
	
//	@Test
//    @Order(1)
//	public void getAllFriendForUserTest() {
//		
//	}
	
	@Test
	@Order(1)
	public void getUserByFriendByOrderStatusByIdTest() {
		when(userRespository.findUserByFriendByOrderStatusById(user.getId())).thenReturn(Stream.of(new User(), new User()).collect(Collectors.toList()));
    	assertEquals(2,friendService.getUserByFriendByOrderStatusById(user.getId()).size());
	}
}
