package com.rentacar.services;

import com.rentacar.model.Modelo;

public interface ModeloService {

	/**
	 * Obtiene un modelo por id del modelo
	 * 
	 * @param idModelo
	 * @return Modelo (Entity)
	 */
	Modelo obtenerModeloPorId(Long idModelo);

}