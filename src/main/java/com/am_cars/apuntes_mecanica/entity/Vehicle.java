package com.am_cars.apuntes_mecanica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad Vehicle - Representa un vehículo
 * 
 * Relación: Muchos vehículos pertenecen a un VehicleOwner
 */
@Entity
@Table(name = "vehicle")
@Data
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "plate", nullable = false, unique = true, length = 20)
	private String plate;
	
	@Column(name = "cylinder_capacity", length = 50)
	private String cylinderCapacity;
	
	@Column(length = 50)
	private String color;
	
	@Column(name = "chassis_number", length = 100)
	private String chassisNumber;
	
	@Column
	private Integer model;
	
	@Column
	private Integer kilometraje;
	
	/**
	 * Relación Many-to-One: Muchos vehículos pertenecen a un VehicleOwner
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_owner_id", nullable = false)
	private VehicleOwner vehicleOwner;
	
	/**
	 * Relación One-to-Many: Un Vehicle puede tener 0 o muchos procedimientos
	 */
	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Procedure> procedures = new ArrayList<>();
	
}

