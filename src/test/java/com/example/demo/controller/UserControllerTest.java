package com.example.demo.controller;


import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.delete;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

import static org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;


<<<<<<< Updated upstream
import com.app.demo.SampleApplication;
=======
import com.app.demo.FacebookApplication;
>>>>>>> Stashed changes
import com.app.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
<<<<<<< Updated upstream
@ContextConfiguration(classes = SampleApplication.class)
=======
@ContextConfiguration(classes = FacebookApplication.class)
>>>>>>> Stashed changes
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	
	User user;
	
	@BeforeEach
	void setUp() throws Exception{
		
		
		user = new User();
		user.setId(14);
		user.setFullName("rajesh");
		user.setEmail("rajesh@gmail.com");
		user.setMobile(8128467893l);
		user.setPassword("rajesh");
		user.setUserStatus(true);
		
	}
	@Test
	public void addUserControllerTest() throws Exception{
		
		this.mvc.perform(post("/user")
	    .content(asJsonString(user))
	    .contentType(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isOk())
		.andDo(document("addUser"
				,responseFields(
						subsectionWithPath("data").description("The user details"),
	        			subsectionWithPath("statusCode").description("The user status code"),
	        			subsectionWithPath("message").description("The user Message")
	        			
				)
				));
		
	}
	
	@Test
	public void getUserDetailsByIdControllerTest() throws Exception{
		
		this.mvc.perform(get("/user/{id}",1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
        .andDo(document("getUserDetailsById"
        		,pathParameters(
				parameterWithName("id").description("get user data based on id"))
        	,responseFields(
        			subsectionWithPath("data").description("The user details"),
        			subsectionWithPath("statusCode").description("The user status code"),
        			subsectionWithPath("message").description("The user Message")
        			

					)
        		));
	
}	
	@Test
	public void updateUserControllerTest() throws Exception{
		user.setMobile(8109808786l);
		user.setEmail("ramesh@gmail.com");
		user.setFullName("ramesh");
		this.mvc.perform(put("/user")
		 .content(asJsonString(user))
		.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("updateUser"
				,responseFields(
						subsectionWithPath("data").description("The user details"),
	        			subsectionWithPath("statusCode").description("The user status code"),
	        			subsectionWithPath("message").description("The user Message")
	        			
				)));
	}
	@Test
	public void getUserByEmailAndPasswordControllerTest() throws Exception{
		user.setEmail("sai@gmail.com");
		user.setPassword("sai");
		this.mvc.perform(post("/user/login")
		.content(asJsonString(user))
		.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
	   .andExpect(status().isOk())
	   .andDo(document("getUserByEmailAndPassword"
			   ));
	}
	@Test
	public void updateUserStatusControllerTest() throws Exception{
		user.setUserStatus(true);
		this.mvc.perform(put("/user/{id}/status/{userStatus}",10,true)
		.content(asJsonString(user))
		.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("updateUserStatus"
				,pathParameters(
						parameterWithName("id").description("get user id"),
				parameterWithName("userStatus").description("updated user status")),responseFields(
						subsectionWithPath("data").description("The user details"),
						subsectionWithPath("statusCode").description("The user status code"),
	        			subsectionWithPath("message").description("The user Message")
	        			
				)));
	}
	@Test
	public void deleteUserControllerTest() throws Exception{
		this.mvc.perform(delete("/user/{id}",21))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("deleteUser"
				,pathParameters(
				parameterWithName("id").description("delete user based on id"))
				));
		
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
