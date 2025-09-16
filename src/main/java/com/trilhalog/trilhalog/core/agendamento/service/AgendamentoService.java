package com.trilhalog.trilhalog.core.agendamento.service;

import java.util.List;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.core.agendamento.enums.StatusDoAgendamento;

public interface AgendamentoService {
	
	List<AgendamentoResponse> buscarTodos();

	AgendamentoResponse agendar(AgendamentoRequest request);

	void deletar(String id);

	void alterarStatus(String id, StatusDoAgendamento status);
}
