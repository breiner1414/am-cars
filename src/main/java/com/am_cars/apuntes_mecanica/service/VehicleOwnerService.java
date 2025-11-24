package com.am_cars.apuntes_mecanica.service;

import com.am_cars.apuntes_mecanica.entity.VehicleOwner;
import com.am_cars.apuntes_mecanica.repository.VehicleOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la entidad VehicleOwner
 */
@Service
@Transactional
public class VehicleOwnerService {
	
	@Autowired
	private VehicleOwnerRepository vehicleOwnerRepository;
	
	/**
	 * Crea un nuevo propietario de vehículo
	 */
	public VehicleOwner create(VehicleOwner vehicleOwner) {
		return vehicleOwnerRepository.save(vehicleOwner);
	}
	
	/**
	 * Obtiene un propietario por ID
	 */
	@Transactional(readOnly = true)
	public Optional<VehicleOwner> findById(Long id) {
		return vehicleOwnerRepository.findById(id);
	}
	
	/**
	 * Obtiene todos los propietarios
	 */
	@Transactional(readOnly = true)
	public List<VehicleOwner> findAll() {
		return vehicleOwnerRepository.findAll();
	}
	
	/**
	 * Actualiza un propietario existente
	 */
	public VehicleOwner update(Long id, VehicleOwner vehicleOwnerDetails) {
		VehicleOwner vehicleOwner = vehicleOwnerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Propietario no encontrado con ID: " + id));
		
		// Actualizar campos
		vehicleOwner.setRol(vehicleOwnerDetails.getRol());
		vehicleOwner.setUsername(vehicleOwnerDetails.getUsername());
		vehicleOwner.setPassword(vehicleOwnerDetails.getPassword());
		vehicleOwner.setEmail(vehicleOwnerDetails.getEmail());
		vehicleOwner.setTipoDocumento(vehicleOwnerDetails.getTipoDocumento());
		vehicleOwner.setNumeroDoc(vehicleOwnerDetails.getNumeroDoc());
		vehicleOwner.setTelefono(vehicleOwnerDetails.getTelefono());
		vehicleOwner.setLastLogin(vehicleOwnerDetails.getLastLogin());
		
		return vehicleOwnerRepository.save(vehicleOwner);
	}
	
	/**
	 * Elimina un propietario por ID
	 */
	public void deleteById(Long id) {
		if (!vehicleOwnerRepository.existsById(id)) {
			throw new RuntimeException("Propietario no encontrado con ID: " + id);
		}
		vehicleOwnerRepository.deleteById(id);
	}
	
	/**
	 * Busca un propietario por username
	 */
	@Transactional(readOnly = true)
	public Optional<VehicleOwner> findByUsername(String username) {
		return vehicleOwnerRepository.findByUsername(username);
	}
	
	/**
	 * Busca un propietario por email
	 */
	@Transactional(readOnly = true)
	public Optional<VehicleOwner> findByEmail(String email) {
		return vehicleOwnerRepository.findByEmail(email);
	}
	
	/**
	 * Busca un propietario por número de documento
	 */
	@Transactional(readOnly = true)
	public Optional<VehicleOwner> findByNumeroDoc(Integer numeroDoc) {
		return vehicleOwnerRepository.findByNumeroDoc(numeroDoc);
	}
	
	/**
	 * Verifica si existe un propietario con el ID dado
	 */
	@Transactional(readOnly = true)
	public boolean existsById(Long id) {
		return vehicleOwnerRepository.existsById(id);
	}
}

