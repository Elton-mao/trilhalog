package com.trilhalog.trilhalog.api.usuario.dto;

import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraResponse;
import com.trilhalog.trilhalog.core.usuario.enums.TipoPerfil;

public record UsuarioResponse(
		String id,
		String nome,
		String telefone,
		String email,
		TipoPerfil tipoPerfil,
		TransportadoraResponse transportadora
		) {

	}

