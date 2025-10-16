package com.trilhalog.trilhalog.api.agendamento.dtos;


import java.time.LocalDate;
import java.time.LocalTime;

import com.trilhalog.trilhalog.api.carga.dtos.CargaResponse;
import com.trilhalog.trilhalog.core.agendamento.enums.TipoDoAgendamento;

/**
 * DTO (Data Transfer Object) para a resposta de um agendamento.
 * 
 * <p>Este record é usado para encapsular os dados de um agendamento a serem enviados
 * em uma resposta de API. Ele é mapeado a partir da entidade {@link com.trilhalog.trilhalog.core.agendamento.entity.Agendamento}.
 * 
 * @param id O identificador único do agendamento.
 * @param tipoDoAgendamento O tipo de agendamento (ex: CARGA, DESCARGA).
 * @param data A data do agendamento.
 * @param hora A hora do agendamento.
 * @param usuarioNome O nome do usuário que realizou o agendamento.
 * @param empresaRazaosocial A razão social da empresa transportadora associada.
 * @param cargaResponse Os detalhes da carga, representados por {@link CargaResponse}.
 */
public record AgendamentoResponse(
		String id,
		TipoDoAgendamento tipoDoAgendamento,
		LocalDate data,
		LocalTime hora,
		String usuarioNome,
		String empresaRazaosocial,
		CargaResponse cargaResponse
		) {

}
