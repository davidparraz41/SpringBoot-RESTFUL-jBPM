package com.example.services;

import java.util.List;

import com.example.model.Persona;

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

	List<Persona> obtenerTodasLasPersona();

}