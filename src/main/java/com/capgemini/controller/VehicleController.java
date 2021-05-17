package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entities.VehicleType;
import com.capgemini.entities.Vehicle;
import com.capgemini.repository.VehicleTypeRepository;
import com.capgemini.repository.VehicleRepository;

@RestController
@RequestMapping("/api/vehicle/")
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;

	@PostMapping("/")
	public String create(@RequestBody Vehicle vehicle){
		
		if(vehicle.getVehicleType()!=null) {
			VehicleType vehi=vehicleTypeRepository.findById(vehicle.getVehicleType().getVehicle_mod_id()).get();
			vehicle.setVehicleType(vehi);
		}
		
		vehicleRepository.save(vehicle);
		return "Vehicle Added";
	}
	
	
	/*@GetMapping("/{id}")
	public Vehicle findById(@PathVariable int id) {
		
		return vehicleRepository.findById(id).get();
	}
	
	
	@PutMapping("/{vehicleId}/department/{vehicleTypeId}")
	public String asssignVehicleType(@PathVariable int vehicleId, @PathVariable int vehicleTypeId ) {
	
		Vehicle vehicle = vehicleRepository.findById(vehicleId).get();
		VehicleType vehicleType =  vehicleTypeRepository.findById(vehicleTypeId).get();
		
		// associate them / link them
		vehicle.setVehicleType(vehicleType);
		//vehicle.getVehicleType().add(vehicleType);
		// update method
		vehicleRepository.save(vehicle);
		
		return "VehicleType Linked";
	}*/
}