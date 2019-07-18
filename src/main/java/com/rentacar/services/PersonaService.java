package com.rentacar.services;

import java.util.List;

import com.rentacar.model.Persona;

public interface PersonaService {

	/**
	 * Crea una neuva persona
	 * 
	 * @param persona
	 */
	void crearNuevaPersona(Persona persona);

	/**
	 * Obtiene una persona por rut
	 * 
	 * @param rut
	 * @return
	 */
	Persona obtenerPersonaPorRut(Integer rut);

	/**
	 * Obtiene todas las personas
	 * 
	 * @return
	 */
	List<Persona> obtenerTodasLasPersona();

}