/**
 * 
 */
package com.rentacar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.dto.SolicitudDto;
import com.rentacar.services.SolicitudService;

/**
 * @author David Parra
 *
 */
@RestController
@RequestMapping("Rest/Solicitud")
public class SolicitudController {

	private static final Logger logger = LoggerFactory.getLogger(SolicitudController.class);

	@Autowired
	SolicitudService solicitudService;

	@PostMapping()
	public ResponseEntity<Void> crearSolicitudDeCotizacion(@RequestBody SolicitudDto solicitudDto) {
		try {
			solicitudService.crearSolicitud(solicitudDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error > " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
