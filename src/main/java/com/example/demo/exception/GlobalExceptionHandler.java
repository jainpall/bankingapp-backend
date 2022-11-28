package com.example.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<String> UserAlreadyExistsException() {
		return new ResponseEntity<String>("User already exists...", HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> UserNotFoundException(){
		return new ResponseEntity<String>("User Not found...", HttpStatus.NOT_FOUND);
	}
}
