package com.am_cars.apuntes_mecanica.service;

import com.am_cars.apuntes_mecanica.entity.Vehicle;
import com.am_cars.apuntes_mecanica.entity.VehicleOwner;
import com.am_cars.apuntes_mecanica.repository.VehicleRepository;
import com.am_cars.apuntes_mecanica.repository.VehicleOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la entidad Vehicle
 */
@Service
@Transactional
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private VehicleOwnerRepository vehicleOwnerRepository;
	
	/**
	 * Crea un nuevo vehículo
	 */
	public Vehicle create(Vehicle vehicle) {
		// Verificar que el propietario existe
		if (vehicle.getVehicleOwner() != null && vehicle.getVehicleOwner().getId() != null) {
			VehicleOwner owner = vehicleOwnerRepository.findById(vehicle.getVehicleOwner().getId())
					.orElseThrow(() -> new RuntimeException("Propietario no encontrado con ID: " + vehicle.getVehicleOwner().getId()));
			vehicle.setVehicleOwner(owner);
		}
		return vehicleRepository.save(vehicle);
	}
	
	/**
	 * Obtiene un vehículo por ID
	 */
	@Transactional(readOnly = true)
	public Optional<Vehicle> findById(Long id) {
		return vehicleRepository.findById(id);
	}
	
	/**
	 * Obtiene todos los vehículos
	 */
	@Transactional(readOnly = true)
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
	
	/**
	 * Actualiza un vehículo existente
	 */
	public Vehicle update(Long id, Vehicle vehicleDetails) {
		Vehicle vehicle = vehicleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + id));
		
		// Actualizar campos
		vehicle.setPlate(vehicleDetails.getPlate());
		vehicle.setCylinderCapacity(vehicleDetails.getCylinderCapacity());
		vehicle.setColor(vehicleDetails.getColor());
		vehicle.setChassisNumber(vehicleDetails.getChassisNumber());
		vehicle.setModel(vehicleDetails.getModel());
		vehicle.setKilometraje(vehicleDetails.getKilometraje());
		
		// Actualizar propietario si se proporciona
		if (vehicleDetails.getVehicleOwner() != null && vehicleDetails.getVehicleOwner().getId() != null) {
			VehicleOwner owner = vehicleOwnerRepository.findById(vehicleDetails.getVehicleOwner().getId())
					.orElseThrow(() -> new RuntimeException("Propietario no encontrado con ID: " + vehicleDetails.getVehicleOwner().getId()));
			vehicle.setVehicleOwner(owner);
		}
		
		return vehicleRepository.save(vehicle);
	}
	
	/**
	 * Elimina un vehículo por ID
	 */
	public void deleteById(Long id) {
		if (!vehicleRepository.existsById(id)) {
			throw new RuntimeException("Vehículo no encontrado con ID: " + id);
		}
		vehicleRepository.deleteById(id);
	}
	
	/**
	 * Busca un vehículo por placa
	 */
	@Transactional(readOnly = true)
	public Optional<Vehicle> findByPlate(String plate) {
		return vehicleRepository.findByPlate(plate);
	}
	
	/**
	 * Verifica si existe un vehículo con la placa dada
	 */
	@Transactional(readOnly = true)
	public boolean existsByPlate(String plate) {
		return vehicleRepository.existsByPlate(plate);
	}
	
	/**
	 * Busca todos los vehículos de un propietario
	 */
	@Transactional(readOnly = true)
	public List<Vehicle> findByVehicleOwnerId(Long vehicleOwnerId) {
		return vehicleRepository.findByVehicleOwnerId(vehicleOwnerId);
	}
	
	/**
	 * Busca un vehículo por número de chasis
	 */
	@Transactional(readOnly = true)
	public Optional<Vehicle> findByChassisNumber(String chassisNumber) {
		return vehicleRepository.findByChassisNumber(chassisNumber);
	}
}

