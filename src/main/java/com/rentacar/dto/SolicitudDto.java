/**
 * 
 */
package com.rentacar.dto;

/**
 * @author David Parra
 *
 */
public class SolicitudDto {

	private Long id;
	private PersonaDto solicitante;
	private ModeloDto modelo;
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
	public PersonaDto getSolicitante() {
		return solicitante;
	}

	/**
	 * @param solicitante the solicitante to set
	 */
	public void setSolicitante(PersonaDto solicitante) {
		this.solicitante = solicitante;
	}

	/**
	 * @return the modelo
	 */
	public ModeloDto getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(ModeloDto modelo) {
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
