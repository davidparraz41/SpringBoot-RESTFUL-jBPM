/**
 * 
 */
package com.rentacar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.model.Persona;
import com.rentacar.repository.PersonaRepository;

/**
 * @author David Parra
 *
 */
@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaRepository personaRepository;

	@Override
	public void crearNuevaPersona(Persona persona) {
		personaRepository.save(persona);
	}

	@Override
	public Persona obtenerPersonaPorRut(Integer rut) {
		return personaRepository.obtenerPersonaPorRut(rut);
	}

	@Override
	public List<Persona> obtenerTodasLasPersona(){
		return personaRepository.findAll();
	}
	
	
}
