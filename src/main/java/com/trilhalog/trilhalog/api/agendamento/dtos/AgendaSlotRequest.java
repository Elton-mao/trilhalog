package com.trilhalog.trilhalog.api.agendamento.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public record AgendaSlotRequest(
		
		@NotNull(message = "{agendaSlot.data.NotNull}")
		LocalDate data,
		
		@NotNull(message = "{agendaSlot.hora.NotNull}")
		LocalTime hora,
		
		@Min(value = 1, message =  "{agendaSlot.vagasTotais.Min}")
		int vagasTotais,
		
		@NotNull(message = "{agendaSlot.docaId.NotNull}")
		String docaId
		) {

}
