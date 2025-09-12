package com.trilhalog.trilhalog.core.usuario.mappers;

import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResponse;
import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResquest;
import com.trilhalog.trilhalog.core.usuario.entity.Usuario;

public interface UsuarioMapper {
	
	UsuarioResponse toUsuarioResponse(Usuario usuario);
	Usuario toUsuario(UsuarioResquest request);
	
}
