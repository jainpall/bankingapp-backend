package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.example.demo.model.Application;
import com.example.demo.model.ApplicationRequest;
import com.example.demo.service.ApplicationService;



@RestController
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000/","http://pallavijainn.com","http://pallavijainn.com:80","http://backend.pallavijainn.com:8080"})
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationServ;
	
	
	Logger logger=LoggerFactory.getLogger(ApplicationController.class);
	
	@PostMapping("/application")
	public ResponseEntity<Application> saveUser(@RequestBody ApplicationRequest application) throws UserAlreadyExistsException {
		Application savedApplication = applicationServ.saveApplication(application);
        System.out.println();
      
		return new ResponseEntity<Application>(savedApplication, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/application/{email}")
	public ResponseEntity<Application> findAApplication(@PathVariable String email) throws UserNotFoundException {
		Application application= applicationServ.findAApplication(email);
		return new ResponseEntity<Application>(application, HttpStatus.OK);
	}
	
	@GetMapping("/applicationbyemail/{email}")
	public ResponseEntity<List<Application>> findAllApplication(@PathVariable String email){
		List<Application> applications = applicationServ.findAllApplications(email);
		return new ResponseEntity<List<Application>>(applications, HttpStatus.OK);
	}

	@DeleteMapping("/application/{email}")
	public ResponseEntity<Application> deleteAApplicationbyId(@PathVariable String email){
		return new ResponseEntity<Application>(applicationServ.deleteAApplication(email),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/application")
	public ResponseEntity<Application> updateAApplication(@RequestBody Application updatedApplication){
		return new ResponseEntity<Application>(applicationServ.updateAApplication(updatedApplication),HttpStatus.CREATED);
	}
	
	

}

