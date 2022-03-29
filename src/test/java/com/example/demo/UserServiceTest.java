package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.demo.SampleApplication;
import com.app.demo.exception.ValidationException;
import com.app.demo.model.User;
import com.app.demo.respository.UserRespository;
import com.app.demo.service.UserService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SampleApplication.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
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
		//user.setUserStatus(false);
    }
    
    @Test
    @Order(1)
    public void addUserTest() throws ValidationException {
        when(userRespository.save(user)).thenReturn(user);
        assertEquals(user, userService.addUser(user));
    }
    
    @Test
    @Order(2)
    public void getUserDetailsByIdTest() {
    	Integer id = 34;
    	when(userRespository.findById(id)).thenReturn(Optional.of(user));
    	assertEquals(user, userService.getUserById(id));
    }
    
    @Test
    @Order(3)
    public void updateUserTest() throws ValidationException {
    	when(userRespository.save(user)).thenReturn(user);
    	user.setFullName("saikrishna");
    	assertNotEquals("chennai", userService.updateUser(user));
    }
    @Test
    @Order(4)
    public void getUserByEmailAndPasswordTest() {
    	String email = "siva@gmail.com";
    	String password = "siva";
    	when(userRespository.findByEmailAndPassword(email, password)).thenReturn(user);
    	assertEquals(user, userService.getUserByEmailAndPassword(email, password));
    }
//    @Test
//    @Order(5)
//    public void updateUserStatusTest() {
//    	Integer id = 1;
//    	boolean userStatus = true;
//    //when(userRespository.findById(user.getId()).get()).thenReturn(user);
//    
//  //  user.setUserStatus(false);
//    when(userRespository.save(user)).thenReturn(user);
//    assertEquals(user,userService.updateUserStatus(id, userStatus));
//    }
    
    @Test
    @Order(6)
    public void deleteUserTest() {
    	when(userRespository.findById(user.getId())).thenReturn(Optional.of(user));
    	userService.deleteUser(user.getId());
    	verify(userRespository).deleteById(user.getId());
    }
    
}
