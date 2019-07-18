package com.rentacar.services;

import com.rentacar.dto.SolicitudDto;

public interface SolicitudService {

	/**
	 * Crea un nueva solicitud de cotizacion en la base de datos y crea una nueva
	 * instancia de proceso (BPM) para dicha solicitud
	 * 
	 * @param solicitudDto
	 * @throws Exception
	 */
	void crearSolicitud(SolicitudDto solicitudDto) throws Exception;

}