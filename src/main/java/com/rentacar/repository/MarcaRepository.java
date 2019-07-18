/**
 * 
 */
package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.model.Marca;

/**
 * @author David Parra
 *
 */
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
