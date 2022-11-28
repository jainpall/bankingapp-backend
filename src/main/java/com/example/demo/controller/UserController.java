package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.JWTRequest;
import com.example.demo.model.JWTResponse;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.User;
import com.example.demo.service.MyUserDetailService;
import com.example.demo.service.UserService;
import com.example.demo.service.util.JWTUtility;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000","http://pallavijainn.com","http://pallavijainn.com:80","http://backend.pallavijainn.com:8080"})
public class UserController {
	
	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	MyUserDetailService userDetailService;
	
	@Autowired
	JWTUtility jwtUtility;


	@Autowired
	UserService userServ;
	
	
	Logger logger=LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
		User savedUser = userServ.saveUser(user);
        System.out.println();
        logger.info(user.getDob().toString());
		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/user/{email}")
	public ResponseEntity<User> findAUser(@PathVariable String email) throws UserNotFoundException {
		User user= userServ.findAUser(email);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> findAllUser(){
		List<User> users = userServ.findAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@DeleteMapping("/user/{email}")
	public ResponseEntity<User> deleteAUserbyId(@PathVariable String email){
		return new ResponseEntity<User>(userServ.deleteAUser(email),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateAUser(@RequestBody User updatedUser){
		return new ResponseEntity<User>(userServ.updateAUser(updatedUser),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public LoginResponse login(@RequestBody JWTRequest request) throws Exception {

       try {
			
			manager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())	
					);	
		}
		catch( BadCredentialsException e ){
			throw new Exception("Wrong_Username_or_Password");
		}	
		
		UserDetails userdetail = userDetailService.loadUserByUsername(request.getEmail());
		String generateToken = jwtUtility.generateToken(userdetail);
		LoginResponse response =new LoginResponse();
		response.setToken(generateToken);
		response.setUser( userServ.findAUser(request.getEmail()));
		return response;
		
	}
	
	
	
	
	
}
	









	
	
	
		
	
	
	