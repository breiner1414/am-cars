package com.am_cars.apuntes_mecanica.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Capa Entity - Representa las tablas de la base de datos
 * 
 * Ejemplo de estructura:
 * - @Entity: Marca la clase como entidad JPA
 * - @Table: Define el nombre de la tabla (opcional)
 * - @Id: Marca el campo como clave primaria
 * - @GeneratedValue: Define la estrategia de generación del ID
 * - @Column: Define propiedades de la columna (opcional)
 * - Lombok @Data: Genera getters, setters, toString, equals, hashCode
 */
@Entity
@Table(name = "ejemplo")
@Data
public class EjemploEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	// Ejemplo de relaciones:
	// @OneToMany, @ManyToOne, @OneToOne, @ManyToMany
}

