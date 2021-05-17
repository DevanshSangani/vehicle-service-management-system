package com.capgemini.entities;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vehicle_reg_no", scope = Integer.class)
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vehicle_reg_no;
	private Integer User_id;
	private String Vehicle_color;
	private String Vehicle_man_yr;
	private String vehicle_desc;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Vehicle_mod_id", referencedColumnName = "vehicle_mod_id")
	private VehicleType vehicleType;
	
}
