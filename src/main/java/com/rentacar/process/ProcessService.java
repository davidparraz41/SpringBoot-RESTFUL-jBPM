package com.rentacar.process;

import java.util.List;

import com.rentacar.dto.TareaDto;
import com.rentacar.dto.VariableDto;

public interface ProcessService {

	/**
	 * Obtiene las tareas de un usuario
	 * 
	 * @param tareaDto
	 * @return
	 * @throws Exception
	 */
	List<TareaDto> obtenerTareasDeUsuario(TareaDto tareaDto);

	/**
	 * Crea una nueva instancia de proceso
	 * 
	 * @param idContenedor
	 * @param nombreProceso
	 * @param variables
	 * @return
	 */
	Long startProcess(String idContenedor, String nombreProceso, List<VariableDto> variables);

	/**
	 * Reclama una tarea
	 * 
	 * @param idContenedor
	 * @param tareaDto
	 * @throws Exception
	 */
	void reclamarTarea(String idContenedor, TareaDto tareaDto);

	/**
	 * Completa una tarea
	 * 
	 * @param tareaDto
	 * @throws Exception
	 */
	void completarTarea(String idContenedor, TareaDto tareaDto);

	/**
	 * Inicia una tarea
	 * 
	 * @param idContenedor
	 * @param tareaDto
	 * @throws Exception
	 */
	void iniciarTarea(String idContenedor, TareaDto tareaDto);

}