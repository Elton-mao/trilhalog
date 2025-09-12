package com.trilhalog.trilhalog.api.transportadora.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trilhalog.trilhalog.core.transportadora.enums.StatusDoCadastroDaTransportadora;

public record TransportadoraResponse(
		String cnpj,
		String razaoSocial,
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
		LocalDateTime dataDoCadastro,
		StatusDoCadastroDaTransportadora statusDoCadastro

		) {

}
