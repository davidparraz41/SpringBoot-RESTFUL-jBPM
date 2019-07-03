/**
 * 
 */
package com.example.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.MarcaDto;
import com.example.mapper.MapperDto;
import com.example.repository.MarcaRepository;

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
		return marcaRepository.findAll().stream().map(marca -> MapperDto.construirMarcaDto(marca))
				.collect(Collectors.toList());
	}

}
