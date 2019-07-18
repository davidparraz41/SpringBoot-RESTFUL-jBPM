/**
 * 
 */
package com.rentacar.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.server.api.model.instance.TaskSummary;

import com.rentacar.dto.MarcaDto;
import com.rentacar.dto.ModeloDto;
import com.rentacar.dto.TareaDto;
import com.rentacar.dto.VariableDto;
import com.rentacar.dto.VehiculoDto;
import com.rentacar.model.Marca;
import com.rentacar.model.Modelo;
import com.rentacar.model.Vehiculo;
import com.rentacar.utils.FechaUtil;

/**
 * Clase utilitaria para mapear un objeto a otro
 * 
 * @author David Parra
 *
 */
public class MapperObject {

	/**
	 * Construye un objeto vehiculoDto (DTO) a partir de un objeto Vehiculo (Entity)
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

	/**
	 * Construye un objeto de tipo MarcaDto (DTO) a partir de un objeto Marca
	 * (Entity)
	 * 
	 * @param marca
	 * @return
	 */
	public static MarcaDto construirMarcaDto(Marca marca) {
		if (marca == null)
			return null;
		MarcaDto marcaDto = new MarcaDto();
		marcaDto.setId(marca.getId());
		marcaDto.setNombre(marca.getNombre());
		return marcaDto;
	}

	/**
	 * Construye un objeto de tipo ModeloDto (DTO) a partir de un objeto Modelo
	 * (Entity)
	 * 
	 * @param modelo
	 * @return
	 */
	public static ModeloDto construirModeloDto(Modelo modelo) {
		if (modelo == null)
			return null;
		ModeloDto modeloDto = new ModeloDto();
		modeloDto.setId(modelo.getId());
		modeloDto.setNombre(modelo.getNombre());
		modeloDto.setMarcaDto(construirMarcaDto(modelo.getMarca()));
		return modeloDto;
	}

	/**
	 * Construye un objeto de tipo TareaDto (DTO) a partir de un objeto TaskSummary
	 * 
	 * @param modelo
	 * @return
	 */
	public static TareaDto contruirTareaDto(TaskSummary taskSummary) {
		if (taskSummary == null)
			return null;
		TareaDto tareaDto = new TareaDto();
		tareaDto.setId(taskSummary.getId());
		tareaDto.setAsunto(taskSummary.getSubject());
		tareaDto.setDescripcion(taskSummary.getDescription());
		tareaDto.setNombre(taskSummary.getName());
		tareaDto.setFechaCreacion(FechaUtil.convertirDateAString(taskSummary.getCreatedOn()));
		tareaDto.setUsuario(taskSummary.getActualOwner());
		return tareaDto;
	}

	/**
	 * Mapea las variables de un objeto VariableDto a un objeto de tipo
	 * java.util.Map
	 * 
	 * @param variables
	 * @return
	 */
	public static Map<String, Object> mapearVariables(List<VariableDto> variables) {
		Map<String, Object> mapa = new HashMap<>();
		if (variables != null && !variables.isEmpty()) {
			for (VariableDto variableDto : variables) {
				mapa.put(variableDto.getNombre(), variableDto.getValor());
			}
		}
		return mapa;
	}

}
