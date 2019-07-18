/**
 * 
 */
package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.model.Modelo;

/**
 * @author David Parra
 *
 */
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
