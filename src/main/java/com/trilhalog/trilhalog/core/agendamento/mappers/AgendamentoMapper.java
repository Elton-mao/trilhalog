package com.trilhalog.trilhalog.core.agendamento.mappers;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Agendamento;

public interface AgendamentoMapper {
	AgendamentoResponse toAgendamentoResponse(Agendamento response);
	Agendamento toAgendamento(AgendamentoRequest agendamentoRequest);
}
