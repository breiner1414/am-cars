package com.am_cars.apuntes_mecanica.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad VehicleOwner - Representa un propietario de vehículo
 * Hereda de Person
 */
@Entity
@Table(name = "vehicle_owner")
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "person_id")
public class VehicleOwner extends Person {
	
	/**
	 * Relación One-to-Many: Un VehicleOwner puede tener 0 o muchos vehículos
	 */
	@OneToMany(mappedBy = "vehicleOwner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Vehicle> vehicles = new ArrayList<>();

	
}

