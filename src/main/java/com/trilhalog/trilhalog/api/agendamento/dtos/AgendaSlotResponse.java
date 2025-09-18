package com.trilhalog.trilhalog.api.agendamento.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.trilhalog.trilhalog.core.agendamento.enums.AgendaSlotStatus;


public record AgendaSlotResponse(
		String id,
		LocalDate data,
		LocalTime hora,
		int vagasTotais,
		int vagasDisponiveis,
		AgendaSlotStatus status,
		String doca
		) {

}
