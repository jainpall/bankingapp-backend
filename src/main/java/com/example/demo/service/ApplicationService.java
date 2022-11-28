package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Application;
import com.example.demo.model.ApplicationRequest;


public interface ApplicationService {
	
	public Application saveApplication (ApplicationRequest application) throws UserAlreadyExistsException;
	public Application findAApplication (String email) throws UserNotFoundException;
	public List<Application> findAllApplications(String email);
	public Application deleteAApplication(String email); //delete request
	public Application updateAApplication(Application application); // PUT - PATCH request
	

}


