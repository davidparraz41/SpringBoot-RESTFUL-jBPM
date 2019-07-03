/**
 * 
 */
package com.example.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Modelo;
import com.example.repository.ModeloRepository;

/**
 * @author David Parra
 *
 */
@Service
public class ModeloServiceImpl implements ModeloService {

	@Autowired
	ModeloRepository modeloRepository;

	@Override
	public Modelo obtenerModeloPorId(Long id) {
		Optional<Modelo> modelo = modeloRepository.findById(id);
		return modelo.isPresent() ? modelo.get() : null;
	}

}
