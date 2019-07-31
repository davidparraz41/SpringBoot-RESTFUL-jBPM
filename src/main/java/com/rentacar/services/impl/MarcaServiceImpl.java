/**
 * 
 */
package com.rentacar.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.dto.MarcaDto;
import com.rentacar.mapper.MapperObject;
import com.rentacar.repository.MarcaRepository;
import com.rentacar.services.MarcaService;

/**
 * @author David Parra
 *
 */
@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	MarcaRepository marcaRepository;

	@Override
	public List<MarcaDto> obtenerTodasLasMarcas() {
		return marcaRepository.findAll().stream().map(marca -> MapperObject.construirMarcaDto(marca))
				.collect(Collectors.toList());
	}

}
