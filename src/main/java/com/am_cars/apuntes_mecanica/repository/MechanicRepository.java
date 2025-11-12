package com.am_cars.apuntes_mecanica.repository;

import com.am_cars.apuntes_mecanica.entity.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository para la entidad Mechanic
 */
@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
	
	/**
	 * Busca un mecánico por username
	 */
	Optional<Mechanic> findByUsername(String username);
	
	/**
	 * Busca un mecánico por email
	 */
	Optional<Mechanic> findByEmail(String email);
	
	/**
	 * Busca un mecánico por número de documento
	 */
	Optional<Mechanic> findByNumeroDoc(Integer numeroDoc);
	
}

