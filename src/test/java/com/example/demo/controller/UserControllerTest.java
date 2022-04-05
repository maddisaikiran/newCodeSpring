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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;



import com.app.demo.SampleApplication;
import com.app.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@ContextConfiguration(classes = SampleApplication.class)
@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	
	User user;
	
	@BeforeEach
	void setUp() throws Exception{
		
		user = new User();
		user.setId(11);
		user.setFullName("ramesh");
		user.setEmail("ramesh@gmail.com");
		user.setMobile(8278453891l);
		user.setPassword("ramesh");
		user.setUserStatus(true);
		
	}
	@Test
	public void addUserControllerTest() throws Exception{
		
		mvc.perform(post("/user")
	    .content(asJsonString(user))
	    .contentType(MediaType.APPLICATION_JSON)).andDo(print())
		.andExpect(status().isOk())
		.andDo(document("addUser"));
		
	}
	
	@Test
	public void getUserDetailsByIdControllerTest() throws Exception{
		
		mvc.perform(get("/user/user/{id}",1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(jsonPath("$.data.id", is(1)))
        .andExpect(jsonPath("$.data.fullName", is("saikiran")))
        .andDo(document("getUserDetailsById"));
	
}	
	@Test
	public void updateUserControllerTest() throws Exception{
		user.setMobile(8017892126l);
		mvc.perform(put("/user")
		 .content(asJsonString(user))
		.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("updateUser"));
	}
	@Test
	public void getUserByEmailAndPasswordControllerTest() throws Exception{
		user.setEmail("ram@gmail.com");
		user.setPassword("ram");
		mvc.perform(post("/user/login")
		.content(asJsonString(user))
		.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
	   .andExpect(status().isOk())
	   .andDo(document("getUserByEmailAndPassword"));
	}
	@Test
	public void updateUserStatusControllerTest() throws Exception{
		user.setUserStatus(true);
		mvc.perform(put("/user/{id}/status/{userStatus}",3,true)
		.content(asJsonString(user))
		.contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("updateUserStatus"));
	}
	@Test
	public void deleteUserControllerTest() throws Exception{
		mvc.perform(delete("/user/{id}",47))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("deleteUser"));
		
	}
	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
