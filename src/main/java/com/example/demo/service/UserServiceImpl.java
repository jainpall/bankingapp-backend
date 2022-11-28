package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;

import com.example.demo.model.User;

import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository UserRepo;
	
	


	@Override
     public User saveUser(User user) throws UserAlreadyExistsException {
		if(UserRepo.existsById(user.getEmail())) {
			throw new UserAlreadyExistsException("User already available..");
		}
		int min = 650;
		int max = 850;
		user.setCreditrating((int)(Math.random()*(max-min+1)+min));
		return UserRepo.save(user);
	}

	@Override
	public User findAUser(String email) throws UserNotFoundException {
		if(!UserRepo.existsById(email)) {
			throw new UserNotFoundException("User Not Found...");
		}
		
		return UserRepo.findById(email).get();
	}

	@Override
	public List<User> findAllUsers() {
		return UserRepo.findAll();
	}



@Override
public User deleteAUser(String email) {
	User deletedUser = null;
	
	Optional optional = UserRepo.findById(email);
	
	if(optional.isPresent()) {
	deletedUser = UserRepo.findById(email).get();
	UserRepo.deleteById(email);
	}
	
	return deletedUser;
}

@Override
public User updateAUser(User User) {
	User updatedUser = null;
	
	Optional optional = UserRepo.findById(User.getEmail());
	
	if (optional.isPresent()) {
		User getUser = UserRepo.findById(User.getEmail()).get();
		getUser.setName(User.getName());
		getUser.setDob(User.getDob());
		getUser.setAddress(User.getAddress());
		getUser.setMobile(User.getMobile());
		getUser.setPancard(User.getPancard());
		getUser.setCreditrating(User.getCreditrating());
		getUser.setPassword(User.getPassword());
		
		updatedUser = UserRepo.save(getUser);
	}
	
	return updatedUser;
}



}



	



