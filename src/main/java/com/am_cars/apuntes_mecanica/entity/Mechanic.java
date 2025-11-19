package com.am_cars.apuntes_mecanica.entity;

import com.am_cars.apuntes_mecanica.entity.enums.Speciality;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
	
	@Column(name = "direccion_taller", length = 255)
	private String direccionTaller;
	
	@Column(name = "telefono_taller", length = 20)
	private String telefonoTaller;
	
	@Column(name = "nombre_taller", length = 100)
	private String nombreTaller;
	
	@Column(name = "horario_atencion", length = 100)
	private String horarioAtencion;
	
	/**
	 * Especialidades del mecánico - Puede tener múltiples especialidades
	 */
	@ElementCollection(fetch = FetchType.LAZY)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "mechanic_specialities", joinColumns = @JoinColumn(name = "mechanic_id"))
	@Column(name = "speciality")
	private List<Speciality> especialidades = new ArrayList<>();
	
}
