package com.am_cars.apuntes_mecanica.dto;

import lombok.Data;

/**
 * Capa DTO - Data Transfer Objects para transferir datos entre capas
 * 
 * Ejemplo de estructura:
 * - DTOs para Request (datos que llegan del cliente)
 * - DTOs para Response (datos que se envían al cliente)
 * - Lombok @Data: Genera getters, setters, toString, equals, hashCode
 * 
 * Ventajas:
 * - Desacopla las entidades de la API
 * - Permite validaciones específicas
 * - Controla qué datos se exponen
 */
@Data
public class EjemploDTO {
	
	private Long id;
	private String nombre;
	
	// Ejemplo de DTOs separados:
	// EjemploRequestDTO - Para crear/actualizar
	// EjemploResponseDTO - Para respuestas
}

