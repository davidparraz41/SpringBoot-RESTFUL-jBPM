/**
 * 
 */
package com.rentacar.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.dto.TareaDto;
import com.rentacar.process.ProcessService;
import com.rentacar.utils.Constantes;

/**
 * @author David Parra
 *
 */
@RestController
@RequestMapping("Rest/Proceso")
public class ProcessController {

	private static final Logger logger = LoggerFactory.getLogger(ProcessController.class);

	@Autowired
	ProcessService processService;

	@PostMapping("Tareas/Usuario")
	public ResponseEntity<List<TareaDto>> obtenerTareasDeUsuario(@RequestBody TareaDto tareaDto) {
		try {
			return new ResponseEntity<>(processService.obtenerTareasDeUsuario(tareaDto), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error > " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("Tarea/Completar")
	public ResponseEntity<Void> completarTarea(@RequestBody TareaDto tareaDto) {
		try {
			processService.completarTarea(Constantes.ID_CONTENEDOR, tareaDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error > " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("Tarea/Reclamar")
	public ResponseEntity<Void> reclamarTarea(@RequestBody TareaDto tareaDto) {
		try {
			processService.reclamarTarea(Constantes.ID_CONTENEDOR, tareaDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error > " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("Tarea/Iniciar")
	public ResponseEntity<Void> iniciarTarea(@RequestBody TareaDto tareaDto) {
		try {
			processService.iniciarTarea(Constantes.ID_CONTENEDOR, tareaDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error > " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
