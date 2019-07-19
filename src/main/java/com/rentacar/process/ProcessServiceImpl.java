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

/**
 * Clase con servicios relacionados con operaciones sobre el motor de proceso
 * 
 * @author David Parra
 *
 */
@Service
public class ProcessServiceImpl implements ProcessService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Long startProcess(String idContenedor, String nombreProceso, List<VariableDto> variables) throws Exception {
		Map<String, Object> mapa = MapperObject.mapearVariables(variables);
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		return management.getProcessClient().startProcess(idContenedor, nombreProceso, mapa);
	}

	@Override
	public List<TareaDto> obtenerTareasDeUsuario(String nombreUsuario, List<String> estadosTarea) throws Exception {
		Usuario usuario = usuarioRepository.obtenerPorNombreUsuario(nombreUsuario);
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		return management.getUserTaskClient(usuario.getNombreUsuario(), usuario.getContrasena())
				.findTasksAssignedAsPotentialOwner(usuario.getNombreUsuario(), estadosTarea, 0, 100).stream()
				.map(task -> MapperObject.contruirTareaDto(task)).collect(Collectors.toList());
	}

	@Override
	public void reclamarTarea(String idContenedor, TareaDto tareaDto) throws Exception {
		Usuario usuario = usuarioRepository.obtenerPorNombreUsuario(tareaDto.getUsuario());
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		management.getUserTaskClient(usuario.getNombreUsuario(), usuario.getContrasena()).claimTask(idContenedor,
				tareaDto.getId(), tareaDto.getUsuario());
	}

	@Override
	public void completarTarea(String idContenedor, TareaDto tareaDto) throws Exception {
		Map<String, Object> variables = MapperObject.mapearVariables(tareaDto.getVariables());
		Usuario usuario = usuarioRepository.obtenerPorNombreUsuario(tareaDto.getUsuario());
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		management.getUserTaskClient(usuario.getNombreUsuario(), usuario.getContrasena()).completeTask(idContenedor,
				tareaDto.getId(), tareaDto.getUsuario(), variables);
	}

	@Override
	public void iniciarTarea(String idContenedor, TareaDto tareaDto) throws Exception {
		Usuario usuario = usuarioRepository.obtenerPorNombreUsuario(tareaDto.getUsuario());
		SetupProcessManagement management = SetupProcessManagement.getInstance();
		management.getUserTaskClient(usuario.getNombreUsuario(), usuario.getContrasena()).startTask(idContenedor,
				tareaDto.getId(), tareaDto.getUsuario());
	}

}
