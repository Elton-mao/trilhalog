package com.trilhalog.trilhalog.core.usuario.mappers;

import org.springframework.stereotype.Component;

import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraResponse;
import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResponse;
import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResquest;
import com.trilhalog.trilhalog.core.transportadora.entity.Transportadora;
import com.trilhalog.trilhalog.core.usuario.entity.Usuario;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {
	
	
	@Override
	public UsuarioResponse toUsuarioResponse(Usuario usuario) {
		
		Transportadora transportadora = usuario.getTransportadora(); 
		
		TransportadoraResponse transResponse = new TransportadoraResponse(
				transportadora.getId(),
				transportadora.getCnpj(),
				transportadora.getRazaoSocial(),
				transportadora.getDataDoCadastro(), 
				transportadora.getStatusDoCadastro());
		
		return new UsuarioResponse(
				usuario.getId(),
				usuario.getNome(),
				usuario.getTelefone(), 
				usuario.getEmail(),
				usuario.getTipoPerfil(),
				transResponse
				);
	}

	@Override
	public Usuario toUsuario(UsuarioResquest request) {
		return new Usuario(
				request.nome(),
				request.telefone(), 
				request.email(),
				request.senha(),
				request.tipoPerfil()
				);
	}

}
