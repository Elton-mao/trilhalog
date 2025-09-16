package com.trilhalog.trilhalog.api.carga.dtos;

import java.math.BigDecimal;

public record CargaResponse(
		String id,
		String descricao,
		String observacao,
		BigDecimal quantidade
		) {

}
