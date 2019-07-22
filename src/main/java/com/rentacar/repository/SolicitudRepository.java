package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.model.Solicitud;

/**
 * @author David Parra
 *
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

}
