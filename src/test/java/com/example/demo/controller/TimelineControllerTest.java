package com.example.demo.controller;


import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.app.demo.SampleApplication;
import com.app.demo.model.Timeline;
import com.app.demo.model.User;

@SpringBootTest
@ContextConfiguration(classes = SampleApplication.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@AutoConfigureMockMvc
public class TimelineControllerTest {

	@Autowired
	private MockMvc mvc;
	
	Timeline timeline;
	
	User user;
	
	@Test
	public void getAllMyTimelineByIdControllerTest() throws Exception{
		
		mvc.perform(get("/timeline/user/{id}",3).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("getAllMyTimelineById"));
	}
	
	@Test
	public void getUserByFriendByTimelineByIdControllerTest() throws Exception{
		mvc.perform(get("/timeline/friend/{userId}",3).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("getUserByFriendByTimelineById"));
		
	}

}
