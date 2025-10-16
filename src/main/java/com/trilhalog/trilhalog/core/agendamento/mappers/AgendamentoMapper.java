package com.trilhalog.trilhalog.core.agendamento.mappers;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Agendamento;

/**
 * Interface para o mapeamento entre a entidade Agendamento e seus DTOs (Data Transfer Objects).
 * 
 * <p>Esta interface define o contrato para a conversão de objetos de e para a camada de persistência,
 * desacoplando a representação interna da externa.</p>
 */
public interface AgendamentoMapper {
    /**
     * Converte uma entidade {@link Agendamento} em um DTO {@link AgendamentoResponse}.
     * 
     * @param response A entidade a ser convertida.
     * @return O DTO correspondente com os dados a serem expostos pela API.
     */
	AgendamentoResponse toAgendamentoResponse(Agendamento response);
	
    /**
     * Converte um DTO {@link AgendamentoRequest} em uma entidade {@link Agendamento}.
     * 
     * @param agendamentoRequest O DTO com os dados de entrada.
     * @return A entidade pronta para ser persistida ou processada.
     */
	Agendamento toAgendamento(AgendamentoRequest agendamentoRequest);
}
