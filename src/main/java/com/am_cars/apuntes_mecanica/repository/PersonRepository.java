package com.am_cars.apuntes_mecanica.repository;

import com.am_cars.apuntes_mecanica.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository para la entidad Person
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	/**
	 * Busca una persona por username
	 */
	Optional<Person> findByUsername(String username);
	
	/**
	 * Busca una persona por email
	 */
	Optional<Person> findByEmail(String email);
	
	/**
	 * Busca una persona por número de documento
	 */
	Optional<Person> findByNumeroDoc(Integer numeroDoc);
	
	/**
	 * Verifica si existe una persona con el username dado
	 */
	boolean existsByUsername(String username);
	
	/**
	 * Verifica si existe una persona con el email dado
	 */
	boolean existsByEmail(String email);
	
	/**
	 * Verifica si existe una persona con el número de documento dado
	 */
	boolean existsByNumeroDoc(Integer numeroDoc);
	
}

