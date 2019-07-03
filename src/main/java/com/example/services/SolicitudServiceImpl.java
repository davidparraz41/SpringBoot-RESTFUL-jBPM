/**
 * 
 */
package com.example.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.SolicitudDto;
import com.example.model.Solicitud;
import com.example.model.enums.EstadoSolicitud;
import com.example.repository.SolicitudRepository;

/**
 * @author David Parra
 *
 */
@Service
public class SolicitudServiceImpl implements SolicitudService {

	@Autowired
	SolicitudRepository solicitudRepository;

	@Autowired
	PersonaService personaService;

	@Autowired
	ModeloService modeloService;

	@Override
	public void crearSolicitud(SolicitudDto solicitudDto) {
		Solicitud solicitud = new Solicitud();
		solicitud.setSolicitante(personaService.obtenerPersonaPorRut(solicitudDto.getSolicitante().getRut()));
		solicitud.setDescripcion(solicitudDto.getDescripcion());
		solicitud.setFechaHora(LocalDateTime.now());
		solicitud.setEstadoSolicitud(EstadoSolicitud.ACTIVA);
		solicitud.setModelo(modeloService.obtenerModeloPorId(solicitudDto.getModelo().getId()));
		solicitudRepository.save(solicitud);
	}

}
