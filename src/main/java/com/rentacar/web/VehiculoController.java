/**
 * 
 */
package com.rentacar.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.dto.VehiculoDto;
import com.rentacar.services.VehiculoService;

/**
 * @author David Parra
 *
 */
@RestController
@RequestMapping("Rest/Vehiculo")
public class VehiculoController {

	private static final Logger logger = LoggerFactory.getLogger(VehiculoController.class);

	@Autowired
	VehiculoService vehiculoService;

	@GetMapping("Vehiculos")
	public ResponseEntity<List<VehiculoDto>> obtenerTodosLosVehiculos() {
		try {
			return new ResponseEntity<>(vehiculoService.obtenerTodosLosVehiculos(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error > " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
