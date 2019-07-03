/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MarcaDto;
import com.example.services.MarcaService;

/**
 * @author David Parra
 *
 */
@RestController
@RequestMapping("Rest/Marca")
public class MarcaController {
	
	@Autowired
	MarcaService marcaService;

	@GetMapping("Marcas")
	public List<MarcaDto> obtenerTodasLasMarcas() {
		return marcaService.obtenerTodasLasMarcas();
	}

}
