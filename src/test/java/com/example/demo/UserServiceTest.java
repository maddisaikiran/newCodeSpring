package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.app.demo.FacebookApplication;
import com.app.demo.model.User;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.UserService;

@ContextConfiguration(classes = FacebookApplication.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
    @MockBean
	UserRespository userRespository;
    
    User user;
    
    @BeforeEach
    void setUp() throws Exception {
    	user = new User();
		user.setId(41);
		user.setFullName("sathya");
		user.setEmail("sathya@gmail.com");
		user.setMobile(9894781235l);
		user.setPassword("sathya");
    }
    
    @Test
    public void addUserTest() {
        when(userRespository.save(user)).thenReturn(user);
        assertEquals(user, userService.addUser(user));
    }
    
    @Test
    public void getUserDetailsByIdTest() {
    	Integer id = 34;
    	when(userRespository.findById(id)).thenReturn(Optional.of(user));
    	assertEquals(user, userService.getUserById(id));
    }
    
    @Test
    public void updateUserTest() {
    	when(userRespository.save(user)).thenReturn(user);
    	user.setFullName("saikrishna");
    	assertNotEquals("chennai", userService.updateUser(user));
    }
    @Test
    public void getUserByEmailAndPasswordTest() {
    	String email = "siva@gmail.com";
    	String password = "siva";
    	when(userRespository.findByEmailAndPassword(email, password)).thenReturn(user);
    	assertEquals(user, userService.getUserByEmailAndPassword(email, password));
    }
    
    @Test
    public void deleteUserTest() {
    	when(userRespository.findById(user.getId())).thenReturn(Optional.of(user));
    	userService.deleteUser(user.getId());
    	verify(userRespository).deleteById(user.getId());
    }
    
}
