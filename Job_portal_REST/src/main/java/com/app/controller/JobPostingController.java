package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.JobPosting;
import com.app.service.JobPostingService;
@RestController
@RequestMapping("/jobpost")

public class JobPostingController {
	@Autowired
	private JobPostingService service;
	
	
	@PostMapping
	public ResponseEntity<JobPosting>cretaeJobPost(@RequestBody JobPosting jobpost){
		JobPosting createdjob=service.cretaeJobPost(jobpost);
		
		return new ResponseEntity<>(createdjob,HttpStatus.CREATED);
		
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<JobPosting>updateJobpost(@PathVariable Long id,@RequestBody JobPosting updatedpost){
		return ResponseEntity.status(HttpStatus.OK).body(service.updateJobPost(id, updatedpost));
		
	}
	
	@GetMapping
	public List<JobPosting>gtJobPostings(){
		return service.getAllPosts();
	}
	
	@DeleteMapping("/{id}")
	public void deletePost( @PathVariable Long id) {
		service.deletePost(id);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<JobPosting>> getjobPostingById( @PathVariable Long id) {
		return  ResponseEntity.status(HttpStatus.OK).body(service.getjobPostingById(id));
		
	}
		
	
	

}
