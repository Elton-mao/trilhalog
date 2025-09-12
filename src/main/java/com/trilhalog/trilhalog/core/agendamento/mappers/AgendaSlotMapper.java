package com.trilhalog.trilhalog.core.agendamento.mappers;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot;

public interface AgendaSlotMapper {
	AgendaSlotResponse toAgendaSlotResponse(AgendaSlot agendaSlot);
	AgendaSlot toAgendaSlot(AgendaSlotRequest request);
}
