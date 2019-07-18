/**
 *
 */
package com.rentacar.process;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rentacar.dto.TareaDto;
import com.rentacar.dto.VariableDto;
import com.rentacar.mapper.MapperObject;

/**
 * Clase con servicios relacionados con operaciones sobre el motor de proceso
 * 
 * @author David Parra
 *
 */
@Service
public class ProcessServiceImpl implements ProcessService {

	@Override
	public Long startProcess(String idContenedor, String nombreProceso, List<VariableDto> variables) throws Exception {
		Map<String, Object> mapa = MapperObject.mapearVariables(variables);
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		return management.getProcessClient().startProcess(idContenedor, nombreProceso, mapa);
	}

	@Override
	public List<TareaDto> obtenerTareasDeUsuario(String usuario, List<String> estadosTarea) throws Exception {
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		return management.getUserTaskClient().findTasksOwned(usuario, estadosTarea, 0, 100).stream()
				.map(task -> MapperObject.contruirTareaDto(task)).collect(Collectors.toList());
	}

	@Override
	public void reclamarTarea(String idContenedor, TareaDto tareaDto) throws Exception {
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		management.getUserTaskClient().claimTask(idContenedor, tareaDto.getId(), tareaDto.getUsuario());
	}

	@Override
	public void completarTarea(String idContenedor, TareaDto tareaDto) throws Exception {
		Map<String, Object> variables = MapperObject.mapearVariables(tareaDto.getVariables());
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		management.getUserTaskClient().completeTask(idContenedor, tareaDto.getId(), tareaDto.getUsuario(), variables);
	}

	@Override
	public void iniciarTarea(String idContenedor, TareaDto tareaDto) throws Exception {
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		management.getUserTaskClient().startTask(idContenedor, tareaDto.getId(), tareaDto.getUsuario());
	}

}
