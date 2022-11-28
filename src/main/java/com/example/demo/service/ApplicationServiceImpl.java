package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Application;
import com.example.demo.model.ApplicationRequest;
import com.example.demo.repository.ApplicationRepository;



	
	@Service
	public class ApplicationServiceImpl implements ApplicationService{
		@Autowired
	    ApplicationRepository ApplicationRepo;
		
		


		@Override
	     public Application saveApplication(ApplicationRequest request) throws UserAlreadyExistsException {
			Application application = new Application();
			application.setEmail(request.getEmail());
			application.setLoanAmount(request.getLoanAmount());
			application.setLoanType(request.getLoanType());
			application.setMonthlyEmi(request.getMonthlyEmi());
			application.setRoi(request.getRoi());
			application.setTenure(request.getTenure());
			return ApplicationRepo.save(application);
		}

		@Override
		public Application findAApplication(String email) throws UserNotFoundException {
			if(!ApplicationRepo.existsById(email)) {
				throw new UserNotFoundException("User Not Found...");
			}
			
			return ApplicationRepo.findById(email).get();
		}

		@Override
		public List<Application> findAllApplications(String email) {
			return ApplicationRepo.findAllByEmail(email);
		}



	@Override
	public Application deleteAApplication(String email) {
		Application deletedUser = null;
		
		Optional optional = ApplicationRepo.findById(email);
		
		if(optional.isPresent()) {
		deletedUser = ApplicationRepo.findById(email).get();
		ApplicationRepo.deleteById(email);
		}
		
		return deletedUser;
	}

	@Override
	public Application updateAApplication(Application Application) {
		Application updatedApplication = null;
		
		Optional optional = ApplicationRepo.findById(Application.getEmail());
		
		if (optional.isPresent()) {
			Application getApplication = ApplicationRepo.findById(Application.getEmail()).get();
			/*
			 * getApplication.setName(Application.getName());
			 * getApplication.setMobile(Application.getMobile());
			 * getApplication.setMonthlyincome(Application.getMonthlyincome());
			 * getApplication.setMonthlyincome(Application.getExistingmonthlyemi());
			 */
			
			
			updatedApplication = ApplicationRepo.save(getApplication);
		}
		
		return updatedApplication;
	}



	}



