package com.am_cars.apuntes_mecanica.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad Procedure - Representa un procedimiento realizado a un vehículo
 * 
 * Relación: Muchos procedimientos pertenecen a un Vehicle
 */
@Entity
@Table(name = "procedure")
@Data
public class Procedure {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "code")
	private Integer code;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column
	private Integer duration;
	
	@Column(length = 50)
	private String date;
	
	@Column
	private Integer note;
	
	/**
	 * Relación Many-to-One: Muchos procedimientos pertenecen a un Vehicle
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;
	
}

