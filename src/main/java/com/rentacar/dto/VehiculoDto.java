/**
 * 
 */
package com.rentacar.dto;

/**
 * @author David Parra
 *
 */
public class VehiculoDto {

	private Long id;
	private Integer anio;
	private String chasis;
	private String patente;
	private ModeloDto modeloDto;

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
	 * @return the anio
	 */
	public Integer getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	/**
	 * @return the chasis
	 */
	public String getChasis() {
		return chasis;
	}

	/**
	 * @param chasis the chasis to set
	 */
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	/**
	 * @return the modeloDto
	 */
	public ModeloDto getModeloDto() {
		return modeloDto;
	}

	/**
	 * @param modeloDto the modeloDto to set
	 */
	public void setModeloDto(ModeloDto modeloDto) {
		this.modeloDto = modeloDto;
	}

	/**
	 * @return the patente
	 */
	public String getPatente() {
		return patente;
	}

	/**
	 * @param patente the patente to set
	 */
	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	

}
