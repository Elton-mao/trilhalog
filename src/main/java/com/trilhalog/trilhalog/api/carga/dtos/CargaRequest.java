package com.trilhalog.trilhalog.api.carga.dtos;

import java.math.BigDecimal;

public record CargaRequest(
		String descricao,
		String observacao,
		BigDecimal quantidade
		) {

}
