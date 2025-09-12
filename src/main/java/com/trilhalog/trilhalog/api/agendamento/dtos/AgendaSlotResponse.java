package com.trilhalog.trilhalog.api.agendamento.dtos;

import java.time.LocalDate;
import java.time.LocalTime;


public record AgendaSlotResponse(
		String id,
		LocalDate data,
		LocalTime hora,
		int vagasTotais,
		int vagasDisponiveis,
		DocaResponse doca
		) {

}
