package com.am_cars.apuntes_mecanica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Capa Repository - Maneja el acceso a datos
 * 
 * Ejemplo de estructura:
 * - @Repository: Marca la interfaz como repositorio (opcional, Spring lo detecta automáticamente)
 * - Extiende JpaRepository<Entity, TipoId> para operaciones CRUD básicas
 * - Puede definir métodos personalizados con queries
 */
@Repository
public interface EjemploRepository extends JpaRepository<Object, Long> {
	
	// Ejemplo de métodos personalizados:
	// @Query("SELECT e FROM Entity e WHERE e.campo = :valor")
	// List<Entity> buscarPorCampo(@Param("valor") String valor);
	
	// Métodos derivados (Spring los genera automáticamente):
	// List<Entity> findByCampo(String campo);
	// Optional<Entity> findByCampoAndOtroCampo(String campo, String otro);
}

