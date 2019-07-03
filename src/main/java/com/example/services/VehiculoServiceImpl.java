/**
 * 
 */
package com.example.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.VehiculoDto;
import com.example.mapper.MapperDto;
import com.example.repository.VehiculoRepository;

/**
 * @author David Parra
 *
 */
@Service
public class VehiculoServiceImpl implements VehiculoService {

	@Autowired
	VehiculoRepository vehiculoRepository;

	@Override
	public List<VehiculoDto> obtenerTodosLosVehiculos() {
		return vehiculoRepository.findAll().stream().map(vehiculo -> MapperDto.construirVehiculoDto(vehiculo))
				.collect(Collectors.toList());
	}

}
