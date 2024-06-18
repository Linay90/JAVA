package com.app.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entiites.User;
import com.app.entiites.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	List<Vehicle>findByUser(User user);
	void deleteByUser(User user);

}
