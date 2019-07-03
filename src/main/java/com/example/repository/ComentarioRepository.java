/**
 * 
 */
package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Comentario;

/**
 * @author David Parra
 *
 */
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

}
