package com.am_cars.apuntes_mecanica.repository;

import com.am_cars.apuntes_mecanica.entity.Vehicle;
import com.am_cars.apuntes_mecanica.entity.VehicleOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository para la entidad Vehicle
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	/**
	 * Busca un vehículo por placa
	 */
	Optional<Vehicle> findByPlate(String plate);
	
	/**
	 * Verifica si existe un vehículo con la placa dada
	 */
	boolean existsByPlate(String plate);
	
	/**
	 * Busca todos los vehículos de un propietario
	 */
	List<Vehicle> findByVehicleOwner(VehicleOwner vehicleOwner);
	
	/**
	 * Busca todos los vehículos por ID del propietario
	 */
	List<Vehicle> findByVehicleOwnerId(Long vehicleOwnerId);
	
	/**
	 * Busca un vehículo por número de chasis
	 */
	Optional<Vehicle> findByChassisNumber(String chassisNumber);
	
}

