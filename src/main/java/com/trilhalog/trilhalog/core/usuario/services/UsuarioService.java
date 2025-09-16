package com.trilhalog.trilhalog.core.usuario.services;

import java.util.List;

import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResponse;
import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResquest;
import com.trilhalog.trilhalog.core.usuario.entity.Usuario;
import com.trilhalog.trilhalog.core.usuario.enums.StatusDoCadastroDoUsuario;

public interface UsuarioService {
	List<UsuarioResponse> listarTodos();
	UsuarioResponse cadastrar(UsuarioResquest request);
	UsuarioResponse editar(UsuarioResquest request, String id);
	void deletar(String id);
	UsuarioResponse desativar(String id,StatusDoCadastroDoUsuario status);
	UsuarioResponse  buscarPorId(String id);
	Usuario buscarPorIdObjeto(String id);
	
}
