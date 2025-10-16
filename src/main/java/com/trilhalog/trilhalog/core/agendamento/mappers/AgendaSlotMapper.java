package com.trilhalog.trilhalog.core.agendamento.mappers;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot;

/**
 * Interface para o mapeamento entre a entidade AgendaSlot e seus DTOs (Data Transfer Objects).
 * 
 * <p>Define o contrato para a conversão de objetos relacionados a slots de agenda,
 * desacoplando a representação interna da externa.</p>
 */
public interface AgendaSlotMapper {
    /**
     * Converte uma entidade {@link AgendaSlot} em um DTO {@link AgendaSlotResponse}.
     * 
     * @param agendaSlot A entidade a ser convertida.
     * @return O DTO correspondente com os dados a serem expostos pela API.
     */
	AgendaSlotResponse toAgendaSlotResponse(AgendaSlot agendaSlot);
	
    /**
     * Converte um DTO {@link AgendaSlotRequest} em uma entidade {@link AgendaSlot}.
     * 
     * @param request O DTO com os dados de entrada.
     * @return A entidade pronta para ser persistida ou processada.
     */
	AgendaSlot toAgendaSlot(AgendaSlotRequest request);
}
