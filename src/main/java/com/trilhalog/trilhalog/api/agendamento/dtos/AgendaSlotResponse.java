package com.trilhalog.trilhalog.api.agendamento.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.trilhalog.trilhalog.core.agendamento.enums.AgendaSlotStatus;

/**
 * DTO (Data Transfer Object) para a resposta de um slot de agenda.
 * 
 * <p>Este record encapsula os dados de um slot de agenda a serem enviados
 * em uma resposta de API. É mapeado a partir da entidade {@link com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot}.
 * 
 * @param id O identificador único do slot de agenda.
 * @param data A data do slot.
 * @param hora A hora de início do slot.
 * @param vagasTotais O número total de vagas no slot.
 * @param vagasDisponiveis O número de vagas ainda disponíveis no slot.
 * @param status O status atual do slot (ex: DISPONIVEL, LOTADO), definido por {@link AgendaSlotStatus}.
 * @param doca O nome da doca associada a este slot.
 */
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
