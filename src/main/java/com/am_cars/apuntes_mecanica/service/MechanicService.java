package com.am_cars.apuntes_mecanica.service;

import com.am_cars.apuntes_mecanica.entity.Mechanic;
import com.am_cars.apuntes_mecanica.repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para la entidad Mechanic
 */
@Service
@Transactional
public class MechanicService {
	
	@Autowired
	private MechanicRepository mechanicRepository;
	
	/**
	 * Crea un nuevo mecánico
	 */
	public Mechanic create(Mechanic mechanic) {
		return mechanicRepository.save(mechanic);
	}
	
	/**
	 * Obtiene un mecánico por ID
	 */
	@Transactional(readOnly = true)
	public Optional<Mechanic> findById(Long id) {
		return mechanicRepository.findById(id);
	}
	
	/**
	 * Obtiene todos los mecánicos
	 */
	@Transactional(readOnly = true)
	public List<Mechanic> findAll() {
		return mechanicRepository.findAll();
	}
	
	/**
	 * Actualiza un mecánico existente
	 */
	public Mechanic update(Long id, Mechanic mechanicDetails) {
		Mechanic mechanic = mechanicRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Mecánico no encontrado con ID: " + id));
		
		// Actualizar campos
		mechanic.setRol(mechanicDetails.getRol());
		mechanic.setUsername(mechanicDetails.getUsername());
		mechanic.setPassword(mechanicDetails.getPassword());
		mechanic.setEmail(mechanicDetails.getEmail());
		mechanic.setTipoDocumento(mechanicDetails.getTipoDocumento());
		mechanic.setNumeroDoc(mechanicDetails.getNumeroDoc());
		mechanic.setTelefono(mechanicDetails.getTelefono());
		mechanic.setLastLogin(mechanicDetails.getLastLogin());
		mechanic.setDireccionTaller(mechanicDetails.getDireccionTaller());
		mechanic.setTelefonoTaller(mechanicDetails.getTelefonoTaller());
		mechanic.setNombreTaller(mechanicDetails.getNombreTaller());
		mechanic.setHorarioAtencion(mechanicDetails.getHorarioAtencion());
		mechanic.setEspecialidades(mechanicDetails.getEspecialidades());
		
		return mechanicRepository.save(mechanic);
	}
	
	/**
	 * Elimina un mecánico por ID
	 */
	public void deleteById(Long id) {
		if (!mechanicRepository.existsById(id)) {
			throw new RuntimeException("Mecánico no encontrado con ID: " + id);
		}
		mechanicRepository.deleteById(id);
	}
	
	/**
	 * Busca un mecánico por username
	 */
	@Transactional(readOnly = true)
	public Optional<Mechanic> findByUsername(String username) {
		return mechanicRepository.findByUsername(username);
	}
	
	/**
	 * Busca un mecánico por email
	 */
	@Transactional(readOnly = true)
	public Optional<Mechanic> findByEmail(String email) {
		return mechanicRepository.findByEmail(email);
	}
	
	/**
	 * Busca un mecánico por número de documento
	 */
	@Transactional(readOnly = true)
	public Optional<Mechanic> findByNumeroDoc(Integer numeroDoc) {
		return mechanicRepository.findByNumeroDoc(numeroDoc);
	}
	
	/**
	 * Verifica si existe un mecánico con el ID dado
	 */
	@Transactional(readOnly = true)
	public boolean existsById(Long id) {
		return mechanicRepository.existsById(id);
	}
}

