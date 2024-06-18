package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.Apiresponse;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public Apiresponse createUser(User user) {
		userRepo.save(user);
		return new Apiresponse("user registered");
		
	}
	

}
