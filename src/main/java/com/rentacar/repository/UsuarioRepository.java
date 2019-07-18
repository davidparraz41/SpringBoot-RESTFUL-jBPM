package com.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
