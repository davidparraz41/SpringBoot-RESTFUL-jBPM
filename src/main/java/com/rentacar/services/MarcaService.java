package com.rentacar.services;

import java.util.List;

import com.rentacar.dto.MarcaDto;

public interface MarcaService {

	/**
	 * Obtiene todas las marces registradas en la base de datos
	 * 
	 * @return List de MarcaDto
	 */
	List<MarcaDto> obtenerTodasLasMarcas();

}