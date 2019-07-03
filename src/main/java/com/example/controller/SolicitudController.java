/**
 * 
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.SolicitudDto;
import com.example.services.SolicitudService;

/**
 * @author David Parra
 *
 */
@RestController
@RequestMapping("Rest/Solicitud")
public class SolicitudController {

	@Autowired
	SolicitudService solicitudService;

	@PostMapping()
	public ResponseEntity<Void> crearSolicitudDeCotizacion(@RequestBody SolicitudDto solicitudDto) {
		try {
			solicitudService.crearSolicitud(solicitudDto);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
