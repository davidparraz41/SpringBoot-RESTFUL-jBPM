/**
 *
 */
package com.rentacar.process;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.dto.TareaDto;
import com.rentacar.dto.VariableDto;
import com.rentacar.mapper.MapperObject;
import com.rentacar.model.Usuario;
import com.rentacar.repository.UsuarioRepository;
import com.rentacar.utils.Constantes;

/**
 * Clase con servicios relacionados con operaciones sobre el motor de procesos JBPM
 * 
 * @author David Parra
 *
 */
@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Long startProcess(String idContenedor, String nombreProceso, List<VariableDto> variables) {
		Map<String, Object> mapa = MapperObject.mapearVariables(variables);
		SetupProcessManagement management = new SetupProcessManagement(Constantes.DEFAULT_USER_SERVER_KIE,
				Constantes.DEFAULT_USER_PASS_SERVER_KIE);
		return management.getProcessClient().startProcess(idContenedor, nombreProceso, mapa);
	}

	@Override
	public List<TareaDto> obtenerTareasDeUsuario(TareaDto tareaDto) {
		Usuario usuario = usuarioRepository.obtenerPorNombreUsuario(tareaDto.getUsuario());
		SetupProcessManagement management = new SetupProcessManagement(usuario.getNombreUsuario(),
				usuario.getContrasena());
		return management.getUserTaskClient()
				.findTasksAssignedAsPotentialOwner(usuario.getNombreUsuario(), tareaDto.getEstados(), 0, 100).stream()
				.map(task -> MapperObject.contruirTareaDto(task)).collect(Collectors.toList());
	}

	@Override
	public void reclamarTarea(String idContenedor, TareaDto tareaDto) {
		Usuario usuario = usuarioRepository.obtenerPorNombreUsuario(tareaDto.getUsuario());
		SetupProcessManagement management = new SetupProcessManagement(usuario.getNombreUsuario(),
				usuario.getContrasena());
		management.getUserTaskClient().claimTask(idContenedor, tareaDto.getId(), tareaDto.getUsuario());
	}

	@Override
	public void completarTarea(String idContenedor, TareaDto tareaDto) {
		Map<String, Object> variables = MapperObject.mapearVariables(tareaDto.getVariables());
		Usuario usuario = usuarioRepository.obtenerPorNombreUsuario(tareaDto.getUsuario());
		SetupProcessManagement management = new SetupProcessManagement(usuario.getNombreUsuario(),
				usuario.getContrasena());
		management.getUserTaskClient().completeTask(idContenedor, tareaDto.getId(), tareaDto.getUsuario(), variables);
	}

	@Override
	public void iniciarTarea(String idContenedor, TareaDto tareaDto) {
		Usuario usuario = usuarioRepository.obtenerPorNombreUsuario(tareaDto.getUsuario());
		SetupProcessManagement management = new SetupProcessManagement(usuario.getNombreUsuario(),
				usuario.getContrasena());
		management.getUserTaskClient().startTask(idContenedor, tareaDto.getId(), tareaDto.getUsuario());
	}

}
