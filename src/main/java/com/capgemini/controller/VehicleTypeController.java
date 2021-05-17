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
//import com.capgemini.entities.Vehicle;
import com.capgemini.repository.VehicleTypeRepository;
//import com.capgemini.repository.VehicleRepository;

@RestController
@RequestMapping("/api/vehicleType/")
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	//@Autowired
	//private VehicleRepository vehicleRepository;

	@PostMapping("/")
	public String create(@RequestBody VehicleType vehicleType) {
		vehicleTypeRepository.save(vehicleType);
		return "VehicleType Added";
	}
	
	/*@GetMapping("/{id}")
	public VehicleType findById(@PathVariable int id) {
		
		return vehicleTypeRepository.findById(id).get();
	}
	
	// TODO
	@PutMapping("/{vehicleTypeId}/vehicle/{vehicleId}")
	public String assignVehicleTypeToVehicle(@PathVariable int vehicleTypeId, @PathVariable int vehicleId) {
		
		VehicleType vehicleType =  vehicleTypeRepository.findById(vehicleTypeId).get();
		Vehicle vehicle =  vehicleRepository.findById(vehicleId).get();
		
		vehicleType.getVehicle().add(vehicle);
		
		// updated.
		vehicleTypeRepository.save(vehicleType);
		return "Successs";
	}*/
}