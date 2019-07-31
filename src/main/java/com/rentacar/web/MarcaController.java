/**
 * 
 */
package com.rentacar.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.dto.MarcaDto;
import com.rentacar.services.MarcaService;

/**
 * @author David Parra
 *
 */
@RestController
@RequestMapping("Rest/Marca")
public class MarcaController {

	private static final Logger logger = LoggerFactory.getLogger(MarcaController.class);

	@Autowired
	MarcaService marcaService;

	@GetMapping("Marcas")
	public ResponseEntity<List<MarcaDto>> obtenerTodasLasMarcas() {
		try {
			return new ResponseEntity<>(marcaService.obtenerTodasLasMarcas(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error > " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
