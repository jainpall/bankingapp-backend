package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
    private UserServiceImpl  userService;
    private User user,user1;
    private List<User> userList;
    private Optional optional;
    
@BeforeEach
void setUp() throws Exception {
	        MockitoAnnotations.initMocks(this);
	        
	
	user = new User("abc@gmail.com","abc","2022-10-22","FBD","9999999999","anknaka",568,100000,"cdscsdcsc");
   user1 = new User("pallavi@gmail.com","Pallavi","13-09-1991","Faridabad","9873831317","ANNNPJKL12",671,100000,"Pass@1234");
  optional = Optional.of(user);
	    }



@AfterEach
public void tearDown() {
    user = null;
}

@Test
void testSaveUser() throws UserAlreadyExistsException {
	 when(userRepository.save(any())).thenReturn(user);
        assertEquals(user, userService.saveUser(user));
        verify(userRepository, times(1)).save(any());
}
@Test
void testfindAllUsers() {
	userRepository.save(user);
	when(userRepository.findAll()).thenReturn(userList);
	List<User> userList1 = userService.findAllUsers();
	assertEquals(userList, userList1);
	verify(userRepository, times(1)).save(user);
	verify(userRepository, times(1)).findAll();
	
}



}
