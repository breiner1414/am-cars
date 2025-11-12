package com.am_cars.apuntes_mecanica.repository;

import com.am_cars.apuntes_mecanica.entity.Procedure;
import com.am_cars.apuntes_mecanica.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository para la entidad Procedure
 */
@Repository
public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
	
	/**
	 * Busca un procedimiento por código
	 */
	Optional<Procedure> findByCode(Integer code);
	
	/**
	 * Busca todos los procedimientos de un vehículo
	 */
	List<Procedure> findByVehicle(Vehicle vehicle);
	
	/**
	 * Busca todos los procedimientos por ID del vehículo
	 */
	List<Procedure> findByVehicleId(Long vehicleId);
	
	/**
	 * Busca procedimientos por nombre
	 */
	List<Procedure> findByNameContainingIgnoreCase(String name);
	
}

