/**
 * 
 */
package com.rentacar.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.dto.SolicitudDto;
import com.rentacar.dto.VariableDto;
import com.rentacar.model.Solicitud;
import com.rentacar.model.enums.EstadoSolicitud;
import com.rentacar.process.ProcessService;
import com.rentacar.repository.SolicitudRepository;
import com.rentacar.utils.Constantes;

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

	@Autowired
	ProcessService processService;

	@Override
	public void crearSolicitud(SolicitudDto solicitudDto) throws Exception {
		Solicitud solicitud = new Solicitud();
		solicitud.setSolicitante(personaService.obtenerPersonaPorRut(solicitudDto.getSolicitante().getRut()));
		solicitud.setDescripcion(solicitudDto.getDescripcion());
		solicitud.setFechaHora(LocalDateTime.now());
		solicitud.setEstadoSolicitud(EstadoSolicitud.ACTIVA);
		solicitud.setModelo(modeloService.obtenerModeloPorId(solicitudDto.getModelo().getId()));
		solicitudRepository.save(solicitud);
		iniciarProcesoDeSolicitud(solicitud.getSolicitante().getNombre(), solicitud.getId());
	}

	private void iniciarProcesoDeSolicitud(String usuario, Long idSolicitud) throws Exception {
		VariableDto variableDto = new VariableDto();
		variableDto.setNombre("idSolicitud");
		variableDto.setValor(idSolicitud.toString());
		processService.startProcess(Constantes.CONTENEDOR, Constantes.PROCESO_SOLICITUD_COTIZACION,
				Arrays.asList(variableDto));
	}

}
