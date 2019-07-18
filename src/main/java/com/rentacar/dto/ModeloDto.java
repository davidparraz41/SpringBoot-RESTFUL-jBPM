/**
 * 
 */
package com.rentacar.dto;

/**
 * @author David Parra
 *
 */
public class ModeloDto {

	private Long id;
	private String nombre;
	private MarcaDto marcaDto;

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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the marcaDto
	 */
	public MarcaDto getMarcaDto() {
		return marcaDto;
	}

	/**
	 * @param marcaDto the marcaDto to set
	 */
	public void setMarcaDto(MarcaDto marcaDto) {
		this.marcaDto = marcaDto;
	}

}
