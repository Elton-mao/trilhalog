package com.trilhalog.trilhalog.core.agendamento.mappers;

import org.springframework.stereotype.Component;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot;

/**
 * Implementação da interface {@link AgendaSlotMapper}.
 * 
 * <p>Esta classe é um componente Spring ({@link Component}) e é responsável por
 * implementar a lógica de conversão entre a entidade {@link AgendaSlot} e seus DTOs.</p>
 */
@Component
public class AgendaSlotMapperImpl implements AgendaSlotMapper{

	/**
	 * {@inheritDoc}
	 * 
	 * <p>Converte manualmente os campos da entidade AgendaSlot para um AgendaSlotResponse.</p>
	 */
	@Override
	public AgendaSlotResponse toAgendaSlotResponse(AgendaSlot agendaSlot) {
		
		return new AgendaSlotResponse(
				agendaSlot.getId(),
				agendaSlot.getData(),
				agendaSlot.getHora(),
				agendaSlot.getVagasTotais(),
				agendaSlot.getVagasDisponiveis(),
				agendaSlot.getStatus(),
				agendaSlot.getDoca().getNome()
				);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>Cria uma nova instância de {@link AgendaSlot} a partir de um {@link AgendaSlotRequest}.</p>
	 */
	@Override
	public AgendaSlot toAgendaSlot(AgendaSlotRequest request) {
		return new AgendaSlot(
				request.data(),
				request.hora(),
				request.vagasTotais()
				);
	}

}
