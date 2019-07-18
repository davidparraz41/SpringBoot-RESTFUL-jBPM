/**
 * 
 */
package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.model.Vehiculo;

/**
 * @author David Parra
 *
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

}
