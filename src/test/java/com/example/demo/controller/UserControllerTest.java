package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.app.demo.SampleApplication;
import com.app.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ContextConfiguration(classes = SampleApplication.class)
//@WebMvcTest(UserController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	
	User user;
	
	@BeforeEach
	void setUp() throws Exception{
		user = new User();
		user.setId(53);
		user.setFullName("rahulf");
		user.setEmail("rahulf@gmail.com");
		user.setMobile(8312123882l);
		user.setPassword("rahul");
		user.setUserStatus(true);
		
	}
	@Test
	@Order(1)
	public void addUserControllerTest() throws Exception{
		mvc.perform(post("/user")
	    .content(asJsonString(user))
	    .contentType(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isOk())
		.andDo(document("addUser"));
		
	}
	
	@Test
	@Order(2)
	public void getUserDetailsByIdControllerTest() throws Exception{
		mvc.perform(get("/user/user/{id}",36))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(jsonPath("$.data.id", is(36)))
        .andExpect(jsonPath("$.data.fullName", is("rajaram")))
        .andDo(document("getUserDetailsById"));
	
}	
	@Test
	@Order(3)
	public void updateUserControllerTest() throws Exception{
		user.setMobile(8978182724l);
		mvc.perform(put("/user")
		 .content(asJsonString(user))
		.contentType(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isOk())
		.andDo(document("updateUser"));
	}
	@Test
	@Order(4)
	public void getUserByEmailAndPasswordControllerTest() throws Exception{
		user.setEmail("raja@gmail.com");
		user.setPassword("raja");
		mvc.perform(post("/user/login")
		.content(asJsonString(user))
		.contentType(MediaType.APPLICATION_JSON)).andDo(print())
	   .andExpect(status().isOk())
	   .andDo(document("getUserByEmailAndPassword"));
	}
	@Test
	@Order(5)
	public void updateUserStatusControllerTest() throws Exception{
		user.setUserStatus(true);
		mvc.perform(put("/user/{id}/status/{userStatus}",36,true)
		.content(asJsonString(user))
		.contentType(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isOk())
		.andDo(document("updateUserStatus"));
	}
	@Test
	@Order(6)
	public void deleteUserControllerTest() throws Exception{
		mvc.perform(delete("/user/{id}",61))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("deleteUser"));
		//.andExpect(jsonPath("$.data.id", is(43)));
		
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
