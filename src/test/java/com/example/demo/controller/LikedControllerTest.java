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

@SpringBootTest
@ContextConfiguration(classes = SampleApplication.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@AutoConfigureMockMvc
public class LikedControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getUserLikesByMessageByIdControllerTest() throws Exception{
		mvc.perform(get("/like/{timeId}",5).contentType(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andDo(document("getUserLikesByMessageById",pathParameters(
				parameterWithName("timeId").description("get user like data based on timeId"))
	        	,responseFields(
	        			subsectionWithPath("data").description("The user like details"),
	        			subsectionWithPath("statusCode").description("The user like status code"),
	        			subsectionWithPath("message").description("The user like Message"),
	        			subsectionWithPath("list.[]").description("the user like details in list")

						)));
	}
	
}
