package com.trilhalog.trilhalog.api.transportadora.dtos;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.validation.constraints.NotBlank;

public record TransportadoraRequest(
		
		@CNPJ(message = "{trans.cnpj.CNPJ}")
		String cnpj,
		
		@NotBlank(message = "{trans.name.NotBlank}")
		String razaoSocial
		) {
}
