package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rentacar.model.Usuario;

/**
 * @author David Parra
 *
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("From Usuario u where u.nombreUsuario=:nombreUsuario")
	Usuario obtenerPorNombreUsuario(@Param("nombreUsuario") String nombreUsuario);

}
