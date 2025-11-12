package com.am_cars.apuntes_mecanica.repository;

import com.am_cars.apuntes_mecanica.entity.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository para la entidad VehicleOwner
 */
@Repository
public interface VehicleOwnerRepository extends JpaRepository<VehicleOwner, Long> {
	
	/**
	 * Busca un propietario de vehículo por username
	 */
	Optional<VehicleOwner> findByUsername(String username);
	
	/**
	 * Busca un propietario de vehículo por email
	 */
	Optional<VehicleOwner> findByEmail(String email);
	
	/**
	 * Busca un propietario de vehículo por número de documento
	 */
	Optional<VehicleOwner> findByNumeroDoc(Integer numeroDoc);
	
}

