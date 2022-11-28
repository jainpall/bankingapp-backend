package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Application;
@Repository
public interface ApplicationRepository extends JpaRepository<Application, String>{

	List<Application> findAllByEmail(String email);
 
	
	
}
