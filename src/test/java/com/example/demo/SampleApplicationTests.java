package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.app.demo.SampleApplication;
import com.app.demo.controller.UserController;

@SpringBootTest(classes = SampleApplication.class)
@ContextConfiguration
//@WebMvcTest(UserController.class)
class SampleApplicationTests {

	@Test
	void contextLoads() {
	}

}
