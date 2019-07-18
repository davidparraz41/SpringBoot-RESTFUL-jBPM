/**
 * 
 */
package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.model.Cotizacion;

/**
 * @author David Parra
 *
 */
public interface CotizacionRepository extends JpaRepository<Cotizacion, Long> {

}
