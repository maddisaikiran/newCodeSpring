package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestMethodOrder;
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
import com.app.demo.model.Timeline;
import com.app.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ContextConfiguration(classes = SampleApplication.class)
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class TimelineControllerTest {

	@Autowired
	private MockMvc mvc;
	
	Timeline timeline;
	
	User user;
	
	@BeforeEach
	void setUp() throws Exception{
		timeline = new Timeline();
    	timeline.setTimeId(35);
    	timeline.setName("time");
    	timeline.setMessage("message");
    	
    	
    	User user = new User();
    	user.setFullName("rajesh");
    	user.setMobile(9902920219l);
        user.setEmail("rajesh@gmail.com");
        user.setId(45);
         timeline.setUser(user);
        
		
	}
	
//	@Test
//	@Order(1)
//	public void addTimeLineControllerTest() throws Exception{
//		mvc.perform(post("/timeline/user/{userId}").contentType(MediaType.APPLICATION_JSON).content(asJsonString(timeline)))
//		.andExpect(status().isOk());
//	}
	
	@Test
	@Order(2)
	public void getAllMyTimelineByIdControllerTest() throws Exception{
		
		mvc.perform(get("/timelines/user/{id}",2).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@Test
	@Order(3)
	public void getUserByFriendByTimelineByIdControllerTest() throws Exception{
		mvc.perform(get("/timeline/friend/{userId}",2).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
