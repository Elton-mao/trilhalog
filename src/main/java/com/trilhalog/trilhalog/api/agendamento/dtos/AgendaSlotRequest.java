package com.trilhalog.trilhalog.api.agendamento.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.trilhalog.trilhalog.core.agendamento.entity.Doca;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * DTO (Data Transfer Object) para a criação ou atualização de um slot de agenda.
 * 
 * <p>Este record encapsula os dados de entrada para a criação de um novo horário (slot)
 * na agenda. Inclui validações para garantir a integridade dos dados.</p>
 * 
 * <p>É mapeado para a entidade {@link com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot}.</p>
 * 
 * @param data A data para a qual o slot está sendo criado. Não pode ser nula.
 * @param hora A hora de início do slot. Não pode ser nula.
 * @param vagasTotais O número total de vagas disponíveis neste slot. Deve ser no mínimo 1.
 * @param docaId O ID da doca ({@link Doca}) à qual este slot pertence. Não pode ser nulo.
 */
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
