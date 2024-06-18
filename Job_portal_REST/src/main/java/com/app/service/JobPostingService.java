package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.JobPosting;
import com.app.exceptions.JobPostingException;
import com.app.repository.JobPostingRepository;

import antlr.collections.List;

//import lombok.Getter;
@Service
@Transactional

public class JobPostingService {
	@Autowired
	 private JobPostingRepository repo;
	 
	public JobPosting cretaeJobPost(JobPosting jobPost) {
		return repo.save(jobPost);
		
	}
	
	public JobPosting updateJobPost(Long id,JobPosting jobPosting){
		
		JobPosting existing=repo.findById(id).orElse(null);
		if(existing !=null) {
			existing.setCompany(jobPosting.getCompany());
			existing.setLocation(jobPosting.getLocation());
			existing.setDescription(jobPosting.getDescription());
			existing.setRequirements(jobPosting.getRequirements());
			existing.setPostingDate(jobPosting.getPostingDate());
			existing.setTitle(jobPosting.getTitle());
			existing.setSalary(jobPosting.getSalary());
			return repo.save(existing);
			
			
			
			
		}
		return null;
	
		
	}
	
	public java.util.List<JobPosting>getAllPosts(){
		return repo.findAll();
	}
	public void  deletePost(Long id) {
	    Optional<JobPosting> jobOptional = repo.findById(id);
	    
	    if (jobOptional.isPresent()) {
	        repo.deleteById(id);
	    } else {
	    	throw new JobPostingException("give correct id!!!");
	  
	    }
	}
	
	
	public Optional<JobPosting> getjobPostingById(Long id) {
		
		return repo.findById(id);
		
	}
	
		
	
	

}
