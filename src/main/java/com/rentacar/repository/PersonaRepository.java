package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rentacar.model.Persona;

/**
 * @author David Parra
 *
 */
public interface PersonaRepository extends JpaRepository<Persona, Long> {

	@Query("From Persona p WHERE p.rut=:rut")
	public Persona obtenerPersonaPorRut(@Param("rut") Integer rut);

}
