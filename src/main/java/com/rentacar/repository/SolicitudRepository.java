package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.model.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
	
	

}
