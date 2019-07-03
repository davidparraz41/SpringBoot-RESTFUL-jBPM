/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Cotizacion;

/**
 * @author David Parra
 *
 */
public interface CotizacionRepository extends JpaRepository<Cotizacion, Long> {

}
