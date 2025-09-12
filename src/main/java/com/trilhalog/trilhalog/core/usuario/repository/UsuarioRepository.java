package com.trilhalog.trilhalog.core.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trilhalog.trilhalog.core.usuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,String>{

}
