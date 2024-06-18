package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.Apiresponse;
import com.app.entities.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/adduser")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<?>createUser(@RequestBody User user){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
	}

}
