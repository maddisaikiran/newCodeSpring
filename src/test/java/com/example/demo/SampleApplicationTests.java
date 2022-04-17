package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.app.demo.FacebookApplication;

@SpringBootTest(classes = FacebookApplication.class)
@ContextConfiguration

class SampleApplicationTests {

	@Test
	void contextLoads() {
	}

}
