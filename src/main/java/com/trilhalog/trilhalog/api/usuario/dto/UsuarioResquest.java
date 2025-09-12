package com.trilhalog.trilhalog.api.usuario.dto;



import com.trilhalog.trilhalog.core.usuario.enums.TipoPerfil;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioResquest(
		
		@NotBlank(message = "{usuario.nome.NotBlank}")
		@Size(min = 2, message ="{usuario.nome.Size}")
		String nome,
		
		@NotBlank(message =" {usuario.telefone.NotBlank}")
		String telefone,
		
		@NotBlank(message = " {usuario.email.NotBlank}")
		@Email(message = "{usuario.email.Email}")
		String email,
		
		@NotBlank(message = "{usuario.senha.Notblank}")
		@Size(min = 8, message ="{usuario.senha.Size}")
		String senha,
		
		@NotNull(message ="{usuario.tipoPerfil.NotNull}")
		TipoPerfil tipoPerfil,
		
		@NotBlank(message ="{usuario.transportadora.Notblank}")
		String  transportadora
		
		) {

	
	}


