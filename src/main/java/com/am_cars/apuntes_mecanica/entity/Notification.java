package com.am_cars.apuntes_mecanica.entity;

import com.am_cars.apuntes_mecanica.entity.enums.NotificationStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Entidad Notification - Representa una notificación
 * 
 * Relación: Una notificación está asociada a un Vehicle y un Procedure
 */
@Entity
@Table(name = "notification")
@Data
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notificacion_id")
	private Long notificacionId;
	
	/**
	 * Relación Many-to-One: Muchas notificaciones pertenecen a un Vehicle
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vehiculo_id", nullable = false)
	@JsonIgnoreProperties({"procedures", "vehicleOwner", "hibernateLazyInitializer", "handler"})
	private Vehicle vehicle;
	
	/**
	 * Relación Many-to-One: Muchas notificaciones pertenecen a un Procedure
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "procedure_id", nullable = false)
	@JsonIgnoreProperties({"vehicle", "mechanic", "hibernateLazyInitializer", "handler"})
	private Procedure procedure;
	
	@Column(nullable = false, length = 500)
	private String message;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private NotificationStatus status;
	
	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	/**
	 * Pre-persist: Establece la fecha de creación automáticamente
	 */
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	
}

