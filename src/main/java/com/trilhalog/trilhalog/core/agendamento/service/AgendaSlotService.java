package com.trilhalog.trilhalog.core.agendamento.service;

import java.util.List;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot;

public interface AgendaSlotService {
	
	List<AgendaSlotResponse> listarTodos(); 
	AgendaSlotResponse buscarPorId(String id); 
	AgendaSlot buscarPorIdEntidade(String id);
	AgendaSlotResponse cadastrar(AgendaSlotRequest request);
	AgendaSlotResponse editar(String id, AgendaSlotRequest request);
	void deletar(String id); 

}
