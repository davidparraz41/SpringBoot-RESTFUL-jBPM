/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Modelo;

/**
 * @author David Parra
 *
 */
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

}
