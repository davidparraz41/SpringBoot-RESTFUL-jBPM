/**
 * 
 */
package com.example.mapper;

import com.example.dto.MarcaDto;
import com.example.dto.ModeloDto;
import com.example.dto.VehiculoDto;
import com.example.model.Marca;
import com.example.model.Modelo;
import com.example.model.Vehiculo;

/**
 * @author David Parra
 *
 */
public class MapperDto {

	

	/**
	 * Construir un vehiculoDto
	 * 
	 * @param vehiculo
	 * @return VehiculoDto
	 */
	public static VehiculoDto construirVehiculoDto(Vehiculo vehiculo) {
		if (vehiculo == null)
			return null;
		VehiculoDto vehiculoDto = new VehiculoDto();
		vehiculoDto.setId(vehiculo.getId());
		vehiculoDto.setAnio(vehiculo.getAnio());
		vehiculoDto.setChasis(vehiculo.getChasis());
		vehiculoDto.setPatente(vehiculo.getPatente());
		vehiculoDto.setModeloDto(construirModeloDto(vehiculo.getModelo()));
		return vehiculoDto;
	}

	public static MarcaDto construirMarcaDto(Marca marca) {
		if (marca == null)
			return null;
		MarcaDto marcaDto = new MarcaDto();
		marcaDto.setId(marca.getId());
		marcaDto.setNombre(marca.getNombre());
		return marcaDto;
	}

	public static ModeloDto construirModeloDto(Modelo modelo) {
		if (modelo == null)
			return null;
		ModeloDto modeloDto = new ModeloDto();
		modeloDto.setId(modelo.getId());
		modeloDto.setNombre(modelo.getNombre());
		modeloDto.setMarcaDto(construirMarcaDto(modelo.getMarca()));
		return modeloDto;
	}

}
