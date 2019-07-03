package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

	@Query("SELECT p FROM Persona p WHERE p.rut=:rut")
	public Persona obtenerPersonaPorRut(@Param("rut") Integer rut);

}
