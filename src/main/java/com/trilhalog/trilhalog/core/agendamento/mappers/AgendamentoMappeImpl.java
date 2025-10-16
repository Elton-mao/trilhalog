package com.trilhalog.trilhalog.core.agendamento.mappers;

import org.springframework.stereotype.Component;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.api.carga.dtos.CargaResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Agendamento;
import com.trilhalog.trilhalog.core.carga.entity.Carga;

/**
 * Implementação da interface {@link AgendamentoMapper}.
 * 
 * <p>Esta classe é um componente Spring ({@link Component}) e é responsável por
 * implementar a lógica de conversão entre a entidade {@link Agendamento} e seus DTOs.</p>
 */
@Component
public class AgendamentoMappeImpl implements AgendamentoMapper {

	/**
	 * {@inheritDoc}
	 * 
	 * <p>Converte manualmente os campos da entidade Agendamento para um AgendamentoResponse,
	 * incluindo dados aninhados de Carga, AgendaSlot e Usuario.</p>
	 */
	@Override
	public AgendamentoResponse toAgendamentoResponse(Agendamento response) {
		Carga carga = response.getCarga();
		CargaResponse cargaResponse = new CargaResponse(carga.getId(), carga.getDescricao(), carga.getObservacao(),
				carga.getQuantidade());
	
		return new AgendamentoResponse(response.getId(), response.getTipoDoAgendamento(),
				response.getAgendaSlot().getData(), response.getAgendaSlot().getHora(),response.getUsuario().getNome(),response.getUsuario().getTransportadora().getRazaoSocial(),cargaResponse
				);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>Cria uma nova instância de {@link Agendamento} a partir de um {@link AgendamentoRequest},
	 * inicializando o tipo do agendamento.</p>
	 */
	@Override
	public Agendamento toAgendamento(AgendamentoRequest agendamentoRequest) {
		return new Agendamento(agendamentoRequest.tipoDoAgendamento());
	}

}
