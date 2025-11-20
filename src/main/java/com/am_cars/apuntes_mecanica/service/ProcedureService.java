package com.am_cars.apuntes_mecanica.service;

import com.am_cars.apuntes_mecanica.entity.Mechanic;
import com.am_cars.apuntes_mecanica.entity.Procedure;
import com.am_cars.apuntes_mecanica.entity.Vehicle;
import com.am_cars.apuntes_mecanica.repository.ProcedureRepository;
import com.am_cars.apuntes_mecanica.repository.VehicleRepository;
import com.am_cars.apuntes_mecanica.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la entidad Procedure
 */
@Service
@Transactional
public class ProcedureService {
	
	@Autowired
	private ProcedureRepository procedureRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private MechanicRepository mechanicRepository;
	
	/**
	 * Crea un nuevo procedimiento
	 */
	public Procedure create(Procedure procedure) {
		// Verificar que el vehículo existe
		if (procedure.getVehicle() != null && procedure.getVehicle().getId() != null) {
			Vehicle vehicle = vehicleRepository.findById(procedure.getVehicle().getId())
					.orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + procedure.getVehicle().getId()));
			procedure.setVehicle(vehicle);
		}
		
		// Verificar que el mecánico existe
		if (procedure.getMechanic() != null && procedure.getMechanic().getId() != null) {
			Mechanic mechanic = mechanicRepository.findById(procedure.getMechanic().getId())
					.orElseThrow(() -> new RuntimeException("Mecánico no encontrado con ID: " + procedure.getMechanic().getId()));
			procedure.setMechanic(mechanic);
		}
		
		return procedureRepository.save(procedure);
	}
	
	/**
	 * Obtiene un procedimiento por código
	 */
	@Transactional(readOnly = true)
	public Optional<Procedure> findByCode(Integer code) {
		return procedureRepository.findByCode(code);
	}
	
	/**
	 * Obtiene un procedimiento por ID
	 */
	@Transactional(readOnly = true)
	public Optional<Procedure> findById(Integer id) {
		return procedureRepository.findById(id);
	}
	
	/**
	 * Obtiene todos los procedimientos
	 */
	@Transactional(readOnly = true)
	public List<Procedure> findAll() {
		return procedureRepository.findAll();
	}
	
	/**
	 * Actualiza un procedimiento existente
	 */
	public Procedure update(Integer code, Procedure procedureDetails) {
		Procedure procedure = procedureRepository.findByCode(code)
				.orElseThrow(() -> new RuntimeException("Procedimiento no encontrado con código: " + code));
		
		// Actualizar campos
		procedure.setName(procedureDetails.getName());
		procedure.setDuration(procedureDetails.getDuration());
		procedure.setDate(procedureDetails.getDate());
		procedure.setNote(procedureDetails.getNote());
		
		// Actualizar vehículo si se proporciona
		if (procedureDetails.getVehicle() != null && procedureDetails.getVehicle().getId() != null) {
			Vehicle vehicle = vehicleRepository.findById(procedureDetails.getVehicle().getId())
					.orElseThrow(() -> new RuntimeException("Vehículo no encontrado con ID: " + procedureDetails.getVehicle().getId()));
			procedure.setVehicle(vehicle);
		}
		
		// Actualizar mecánico si se proporciona
		if (procedureDetails.getMechanic() != null && procedureDetails.getMechanic().getId() != null) {
			Mechanic mechanic = mechanicRepository.findById(procedureDetails.getMechanic().getId())
					.orElseThrow(() -> new RuntimeException("Mecánico no encontrado con ID: " + procedureDetails.getMechanic().getId()));
			procedure.setMechanic(mechanic);
		}
		
		return procedureRepository.save(procedure);
	}
	
	/**
	 * Elimina un procedimiento por código
	 */
	public void deleteByCode(Integer code) {
		Procedure procedure = procedureRepository.findByCode(code)
				.orElseThrow(() -> new RuntimeException("Procedimiento no encontrado con código: " + code));
		procedureRepository.delete(procedure);
	}
	
	/**
	 * Busca todos los procedimientos de un vehículo
	 */
	@Transactional(readOnly = true)
	public List<Procedure> findByVehicleId(Long vehicleId) {
		return procedureRepository.findByVehicleId(vehicleId);
	}
	
	/**
	 * Busca procedimientos por nombre (búsqueda parcial, case-insensitive)
	 */
	@Transactional(readOnly = true)
	public List<Procedure> findByNameContaining(String name) {
		return procedureRepository.findByNameContainingIgnoreCase(name);
	}
	
	/**
	 * Verifica si existe un procedimiento con el código dado
	 */
	@Transactional(readOnly = true)
	public boolean existsByCode(Integer code) {
		return procedureRepository.findByCode(code).isPresent();
	}
}

