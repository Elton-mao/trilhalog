package com.trilhalog.trilhalog.api.agendamento.dtos;


import java.time.LocalDate;
import java.time.LocalTime;

import com.trilhalog.trilhalog.api.carga.dtos.CargaResponse;
import com.trilhalog.trilhalog.core.agendamento.enums.TipoDoAgendamento;


public record AgendamentoResponse(
		String id,
		TipoDoAgendamento tipoDoAgendamento,
		LocalDate data,
		LocalTime hora,
		String usuarioNome,
		String empresaRazaosocial,
		CargaResponse cargaResponse
		) {

}
