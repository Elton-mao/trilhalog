package com.trilhalog.trilhalog.api.agendamento.dtos;


import com.trilhalog.trilhalog.api.carga.dtos.CargaRequest;
import com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot;
import com.trilhalog.trilhalog.core.agendamento.enums.TipoDoAgendamento;
import com.trilhalog.trilhalog.core.usuario.entity.Usuario;

/**
 * DTO (Data Transfer Object) para a criação de um novo agendamento.
 * 
 * <p>Este record é usado para encapsular os dados recebidos em uma requisição
 * para criar um agendamento. Ele é então mapeado para a entidade {@link com.trilhalog.trilhalog.core.agendamento.entity.Agendamento}.
 * 
 * @param tipoDoAgendamento O tipo de agendamento (ex: CARGA, DESCARGA).
 * @param agendaSlot O ID do slot de agenda ({@link AgendaSlot}) que está sendo reservado.
 * @param carga Os detalhes da carga a ser transportada, representados por {@link CargaRequest}.
 * @param usuario O ID do usuário ({@link Usuario}) que está realizando o agendamento.
 */
public record AgendamentoRequest(
		TipoDoAgendamento tipoDoAgendamento,
		String agendaSlot,
		CargaRequest carga,
		String usuario
		) {

}
