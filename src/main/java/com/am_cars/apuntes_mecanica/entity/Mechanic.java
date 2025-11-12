package com.am_cars.apuntes_mecanica.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Entidad Mechanic - Representa un mecánico
 * Hereda de Person
 */
@Entity
@Table(name = "mechanic")
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "person_id")
public class Mechanic extends Person {
	

	
}

