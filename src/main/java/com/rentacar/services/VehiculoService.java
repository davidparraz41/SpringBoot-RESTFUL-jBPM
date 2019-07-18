package com.rentacar.services;

import java.util.List;

import com.rentacar.dto.VehiculoDto;

public interface VehiculoService {

	/**
	 * Obtiene una lista de todos los vehiculos registrados en la base de datos
	 * 
	 * @return una lista(java.util.List) de VehiculoDto
	 */
	List<VehiculoDto> obtenerTodosLosVehiculos();

}