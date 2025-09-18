package com.trilhalog.trilhalog.core.agendamento.mappers;

import org.springframework.stereotype.Component;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot;

@Component
public class AgendaSlotMapperImpl implements AgendaSlotMapper{

	@Override
	public AgendaSlotResponse toAgendaSlotResponse(AgendaSlot agendaSlot) {
		
		return new AgendaSlotResponse(
				agendaSlot.getId(),
				agendaSlot.getData(),
				agendaSlot.getHora(),
				agendaSlot.getVagasTotais(),
				agendaSlot.getVagasDisponiveis(),
				agendaSlot.getStatus(),
				agendaSlot.getDoca().getNome()
				);
	}

	@Override
	public AgendaSlot toAgendaSlot(AgendaSlotRequest request) {
		return new AgendaSlot(
				request.data(),
				request.hora(),
				request.vagasTotais()
				);
	}

}
