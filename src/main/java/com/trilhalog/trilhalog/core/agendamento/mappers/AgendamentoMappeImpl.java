package com.trilhalog.trilhalog.core.agendamento.mappers;

import org.springframework.stereotype.Component;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.api.carga.dtos.CargaResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Agendamento;
import com.trilhalog.trilhalog.core.carga.entity.Carga;

@Component
public class AgendamentoMappeImpl implements AgendamentoMapper {

	@Override
	public AgendamentoResponse toAgendamentoResponse(Agendamento response) {
		Carga carga = response.getCarga();
		CargaResponse cargaResponse = new CargaResponse(carga.getId(), carga.getDescricao(), carga.getObservacao(),
				carga.getQuantidade());
	
		return new AgendamentoResponse(response.getId(), response.getTipoDoAgendamento(),
				response.getAgendaSlot().getData(), response.getAgendaSlot().getHora(),response.getUsuario().getNome(),response.getUsuario().getTransportadora().getRazaoSocial(),cargaResponse
				);
	}

	@Override
	public Agendamento toAgendamento(AgendamentoRequest agendamentoRequest) {
		return new Agendamento(agendamentoRequest.tipoDoAgendamento());
	}

}
