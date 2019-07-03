/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Marca;

/**
 * @author David Parra
 *
 */
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
