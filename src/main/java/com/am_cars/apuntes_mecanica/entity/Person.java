package com.am_cars.apuntes_mecanica.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entidad base Person - Representa una persona en el sistema
 * 
 * Esta es una clase abstracta que será heredada por VehicleOwner y Mechanic
 */
@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 50)
	private String rol;
	
	@Column(nullable = false, unique = true, length = 100)
	private String username;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(nullable = false, unique = true, length = 255)
	private String email;
	
	@Column(name = "tipo_documento", nullable = false, length = 50)
	private String tipoDocumento;
	
	@Column(name = "numero_doc", nullable = false, unique = true)
	private Integer numeroDoc;
	
	@Column(length = 20)
	private Integer telefono;
	
	@Column(name = "last_login")
	private LocalDateTime lastLogin;
	
}

