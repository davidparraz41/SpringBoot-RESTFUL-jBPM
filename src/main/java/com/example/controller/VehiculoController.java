/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.VehiculoDto;
import com.example.services.VehiculoService;

/**
 * @author David Parra
 *
 */
@RestController
@RequestMapping("Rest/Vehiculo")
public class VehiculoController {

	@Autowired
	VehiculoService vehiculoService;

	@GetMapping("Vehiculos")
	public ResponseEntity<List<VehiculoDto>> obtenerTodasLasPersonas() {
		return new ResponseEntity<>(vehiculoService.obtenerTodosLosVehiculos(), HttpStatus.OK);
	}

}
