package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes


import com.app.demo.FacebookApplication;
import com.app.demo.model.Friend;
import com.app.demo.model.User;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.FriendService;
import com.app.demo.service.UserSearchService;


<<<<<<< Updated upstream
@ContextConfiguration(classes = SampleApplication.class)
=======
@ContextConfiguration(classes = FacebookApplication.class)
>>>>>>> Stashed changes
@SpringBootTest
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
	
	@Test
	public void getUserByFriendByOrderStatusByIdTest() {
		when(userRespository.findUserByFriendByOrderStatusById(user.getId())).thenReturn(Stream.of(new User(), new User()).collect(Collectors.toList()));
    	assertEquals(2,friendService.getUserByFriendByOrderStatusById(user.getId()).size());
	}
}
