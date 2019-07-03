/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Vehiculo;

/**
 * @author David Parra
 *
 */
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

}
