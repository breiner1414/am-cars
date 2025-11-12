package com.am_cars.apuntes_mecanica.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Capa Controller - Maneja las peticiones HTTP REST
 * 
 * Ejemplo de estructura:
 * - @RestController: Marca la clase como controlador REST
 * - @RequestMapping: Define la ruta base del controlador
 * - Métodos con @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
 */
@RestController
@RequestMapping("/api")
public class EjemploController {
	
	// Ejemplo de endpoints REST
	// @GetMapping("/ejemplo")
	// @PostMapping("/ejemplo")
	// @PutMapping("/ejemplo/{id}")
	// @DeleteMapping("/ejemplo/{id}")
}

