package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entiites.Vehicle;
import com.app.service.VehicleService;

@RestController
@RequestMapping("/add")
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	
	@PostMapping
	public ResponseEntity<?>addNewVehicle(@RequestBody Vehicle vehicle){
		return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addNewVehicle(vehicle));
		
	}
	
	@GetMapping("/username")
	public List<Vehicle>getAllVehiclesByUsername(@RequestParam String username){
		
		return  vehicleService.getVehicleByUserName(username);
		
		
	}
	
	@DeleteMapping
	public void deleteByUserName(@RequestParam String username) {
		vehicleService.deletevehicleByUserName(username);
	}
	

}
