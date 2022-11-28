package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;

import com.example.demo.model.User;

public interface UserService {
	
		public User saveUser (User email) throws UserAlreadyExistsException;
		public User findAUser(String email) throws UserNotFoundException;
		public List<User> findAllUsers();
		public User deleteAUser(String email); //delete request
		public User updateAUser(User user); // PUT - PATCH request
		

	}








