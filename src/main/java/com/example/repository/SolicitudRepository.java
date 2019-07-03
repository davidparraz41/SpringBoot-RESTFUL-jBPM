package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
	
	

}
