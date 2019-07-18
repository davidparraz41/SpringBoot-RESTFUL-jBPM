/**
 * 
 */
package com.rentacar.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rentacar.model.enums.EstadoSolicitud;

/**
 * @author David Parra
 *
 */
@Entity
public class Solicitud {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "solicitante_id")
	private Persona solicitante;

	private LocalDateTime fechaHora;

	@Enumerated(EnumType.STRING)
	private EstadoSolicitud estadoSolicitud;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;

	private String descripcion;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the solicitante
	 */
	public Persona getSolicitante() {
		return solicitante;
	}

	/**
	 * @param solicitante the solicitante to set
	 */
	public void setSolicitante(Persona solicitante) {
		this.solicitante = solicitante;
	}

	/**
	 * @return the fechaHora
	 */
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the estadoSolicitud
	 */
	public EstadoSolicitud getEstadoSolicitud() {
		return estadoSolicitud;
	}

	/**
	 * @param estadoSolicitud the estadoSolicitud to set
	 */
	public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	/**
	 * @return the modelo
	 */
	public Modelo getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
