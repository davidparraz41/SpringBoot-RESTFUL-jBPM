/**
 * 
 */
package com.rentacar.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.dto.VehiculoDto;
import com.rentacar.mapper.MapperObject;
import com.rentacar.repository.VehiculoRepository;

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
		return vehiculoRepository.findAll().stream().map(vehiculo -> MapperObject.construirVehiculoDto(vehiculo))
				.collect(Collectors.toList());
	}

}
