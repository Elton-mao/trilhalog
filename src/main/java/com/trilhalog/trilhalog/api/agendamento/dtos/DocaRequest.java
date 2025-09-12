package com.trilhalog.trilhalog.api.agendamento.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DocaRequest(
		@NotBlank(message = "{doca.nome.NotBlank}")
		@Size(min = 2, message ="{doca.nome.Size}" )
		String nome
		) {
}
