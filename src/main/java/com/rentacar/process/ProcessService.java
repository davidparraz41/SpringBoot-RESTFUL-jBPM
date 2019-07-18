package com.rentacar.process;

import java.util.List;

import com.rentacar.dto.TareaDto;
import com.rentacar.dto.VariableDto;

public interface ProcessService {

	/**
	 * Obtiene las tareas de un usuario
	 * 
	 * @param usuario
	 * @param estados
	 * @return List<TareaDto>
	 */
	List<TareaDto> obtenerTareasDeUsuario(String usuario, List<String> estados) throws Exception;

	/**
	 * Crea una nueva instancia de proceso
	 * 
	 * @param idContenedor
	 * @param nombreProceso
	 * @param idSolicitud
	 * @return processInstanceId
	 * @throws Exception
	 */
	Long startProcess(String idContenedor, String nombreProceso, List<VariableDto> variables) throws Exception;

	/**
	 * Reclama una tarea
	 * 
	 * @param idContenedor
	 * @param tareaDto
	 * @throws Exception
	 */
	void reclamarTarea(String idContenedor, TareaDto tareaDto) throws Exception;

	/**
	 * Completa una tarea
	 * 
	 * @param tareaDto
	 * @throws Exception
	 */
	void completarTarea(String idContenedor, TareaDto tareaDto) throws Exception;

	/**
	 * Inicia una tarea
	 * 
	 * @param idContenedor
	 * @param tareaDto
	 * @throws Exception
	 */
	void iniciarTarea(String idContenedor, TareaDto tareaDto) throws Exception;

}