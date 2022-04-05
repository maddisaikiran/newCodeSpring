package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.app.demo.model.Timeline;
import com.app.demo.model.User;
import com.app.demo.respository.TimelineRepository;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.TimelineService;
import com.app.demo.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SampleApplication.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class TimelineServiceTest {

	@Autowired
	UserService userService;
	
	@Autowired
	TimelineService timelineService;
	
	@MockBean
	UserRespository userRespository;
	
	@MockBean
	TimelineRepository timelineRepository;
	
	Timeline timeline;
	
	User user;
	 
    @BeforeEach
    void setUp() throws Exception {
    	timeline = new Timeline();
    	timeline.setTimeId(33);
    	timeline.setImage(null);
    	timeline.setMessage("this is sasi");
    	
    	user = new User();
    	user.setId(2);
    	
    	timeline.setUser(user);
    	
    	//user.getId();
    	//timeline.setUser(user);
    	
    	
    }
    
    @Test
    @Order(1)
    public void addTimeLineTest() throws ValidationException{
    	User user = new User();
    	user.setFullName("rajesh");
    	user.setMobile(9902920219l);
        user.setEmail("rajesh@gmail.com");
        
        User newUser = userRespository.save(user);
        timeline.setUser(newUser);
    	
    	when(userRespository.findById(user.getId())).thenReturn(Optional.of(user));
    	when(timelineRepository.save(timeline)).thenReturn(timeline);
    	assertEquals(timeline,timelineService.addTimeLine(timeline,user.getId()));
    }
    
    @Test
    @Order(2)
    public void getAllMyTimelineByIdTest() {
    	
    	when(userRespository.findById(user.getId())).thenReturn(Optional.of(user));
    	when(timelineRepository.findAllByUser(user)).thenReturn(Stream.of(new Timeline(), new Timeline()).collect(Collectors.toList()));
    	assertEquals(2, timelineService.getAllMyTimelineById(user.getId()).size());
    }
    
    @Test
    @Order(3)
    public void getUserByFriendByTimelineByIdTest() {
    	
    	when(timelineRepository.findUserByFriendByTimelineById(user.getId())).thenReturn(Stream.of(new Timeline(), new Timeline()).collect(Collectors.toList()));
    	assertEquals(2,timelineService.getUserByFriendByTimelineById(user.getId()).size());
    }
    
    
    
    
}
