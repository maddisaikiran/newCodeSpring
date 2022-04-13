package com.example.demo.controller;


import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
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
		
		mvc.perform(get("/timeline/user/{id}",1).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("getAllMyTimelineById",pathParameters(
				parameterWithName("id").description("get timeline data based on id"))
	        	,responseFields(
	        			subsectionWithPath("data").description("The timeline details"),
	        			subsectionWithPath("statusCode").description("The timeline status code"),
	        			subsectionWithPath("message").description("The timeline Message"),
	        			subsectionWithPath("list.[]").description("the timeline details in list")

						)));
	}
	
	@Test
	public void getUserByFriendByTimelineByIdControllerTest() throws Exception{
		mvc.perform(get("/timeline/friend/{userId}",1).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("getUserByFriendByTimelineById",pathParameters(
				parameterWithName("userId").description("get timeline data based on id"))
	        	,responseFields(
	        			subsectionWithPath("data").description("The timeline details"),
	        			subsectionWithPath("statusCode").description("The timeline status code"),
	        			subsectionWithPath("message").description("The timeline Message"),
	        			subsectionWithPath("list.[]").description("the timeline details in list")
	        			)));
		
	}

}
