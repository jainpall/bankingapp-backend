package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;

@Service
	public class MyUserDetailService implements UserDetailsService {

		
		@Autowired
		UserRepository userRepo; 
		
		

		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			 com.example.demo.model.User user = userRepo.findById(email).get();
			 return new User(user.getEmail(), user.getPassword(), new ArrayList<>()) ;
		}

	}



