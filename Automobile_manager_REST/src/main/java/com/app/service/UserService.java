package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.entiites.User;
import com.app.respository.UserRepository;
@Service
@Transactional

public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public ApiResponse createUser(User user) {
		 userRepository.save(user);
		 return new ApiResponse("added successfully");
	}
	

}
