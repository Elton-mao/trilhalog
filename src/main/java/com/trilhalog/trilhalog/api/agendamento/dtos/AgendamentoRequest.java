package com.trilhalog.trilhalog.api.agendamento.dtos;


import com.trilhalog.trilhalog.api.carga.dtos.CargaRequest;
import com.trilhalog.trilhalog.core.agendamento.enums.TipoDoAgendamento;


public record AgendamentoRequest(
		TipoDoAgendamento tipoDoAgendamento,
		String agendaSlot,
		CargaRequest carga,
		String usuario
		) {

}
