package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exc.ResourceNotFound;
import com.app.dto.ApiResponse;
import com.app.entiites.User;
import com.app.entiites.Vehicle;
import com.app.respository.UserRepository;
import com.app.respository.VehicleRepository;
@Service
@Transactional
public class VehicleService {
	@Autowired
	VehicleRepository vehicleRepo;
	@Autowired
	UserRepository userRepo;
	
	public ApiResponse addNewVehicle(Vehicle vehicle) {
		String message="vehicle registarion failed";
		User user=userRepo.findByUserName(vehicle.getUser().getUserName());
		if(user !=null) {
			vehicle.setUser(user);
			vehicleRepo.save(vehicle);
			message="vehicle registered successfully";
		}
		
		return new ApiResponse(message);
		
	}
	
	public List<Vehicle>getVehicleByUserName(String userName){
		User user=userRepo.findByUserName(userName);
		if(user!=null) {
			return vehicleRepo.findByUser(user);
		}
		throw new ResourceNotFound("user name does not exist");
	}
	
	public ApiResponse deletevehicleByUserName(String username) {
		String msg="deletion failed";
		User user=userRepo.findByUserName(username);
		if(user!=null) {
			vehicleRepo.deleteByUser(user);
			return new ApiResponse("deleted successfully");
		}
		return new ApiResponse(msg);
		
	}

}
