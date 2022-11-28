package com.example.demo.controller;




import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;


@TestMethodOrder(OrderAnnotation.class)
@ComponentScan(basePackages = "com.restservices.demo")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = { UserContollerTest.class })
public class UserContollerTest {

	
	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	UserService userServ;
	
	@InjectMocks
	UserController userController;
	
	List<User> myusers;
	User user;
	
	
	@BeforeEach
	public void setUp()
	{
		mockMvc=MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	// Test cases for testing UserController  
	
	@Test
	@Order(1)
	public void test_findAllUsers() throws Exception
	{
		myusers = new ArrayList<User>();
		myusers.add(new User("abc@gmail.com","abc","2022-10-22","FBD","9999999999","anknaka",568,100000,"cdscsdcsc"));
		myusers.add(new User("dev@gmail.com","dev","2022-10-25","FBD","9999999909","anknape",786,100090,"cdscsdaml"));
	
		when(userServ.findAllUsers()).thenReturn(myusers);
		
		this.mockMvc.perform(get("/user"))
			.andExpect(status().isOk())
			.andDo(print());
	}
	
	

	@Test
	@Order(2)
	public void test_findAUser() throws Exception
	{
		user = new User("pep@gmail.com","pep","2022-10-22","FBD","9999999990","anknabc",576,100010,"cdscsdced");
		
		String email="pep@gmail.com";
		
		when(userServ.findAUser(email)).thenReturn(user);
		
		this.mockMvc.perform(get("/user/{email}",email))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath(".email").value("pep@gmail.com"))
		.andExpect(MockMvcResultMatchers.jsonPath(".name").value("pep"))
		.andExpect(MockMvcResultMatchers.jsonPath(".dob").value("2022-10-22"))
		.andExpect(MockMvcResultMatchers.jsonPath(".address").value("FBD"))
		.andExpect(MockMvcResultMatchers.jsonPath(".mobile").value("9999999990"))
		.andExpect(MockMvcResultMatchers.jsonPath(".pancard").value("anknabc"))
		.andExpect(MockMvcResultMatchers.jsonPath(".creditrating").value(576))
		.andExpect(MockMvcResultMatchers.jsonPath(".monthlyincome").value(100010))
		.andDo(print());
		
	}
	
	@Test
	@Order(3)
	public void test_saveUser() throws Exception
	{
		user = new User("name@gmail.com","name","2022-10-22","FBD","9999999960","anknaec",506,100910,"cdscseced");
		when(userServ.saveUser(user)).thenReturn(user);
		
		ObjectMapper mapper=new ObjectMapper();
		String jsonbody=mapper.writeValueAsString(user);
		
		this.mockMvc.perform(post("/user")
				.content(jsonbody)
				.contentType(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().isCreated())
		.andDo(print());
		
		
	}
	
}