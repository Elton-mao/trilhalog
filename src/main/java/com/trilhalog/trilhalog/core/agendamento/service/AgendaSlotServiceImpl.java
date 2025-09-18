package com.trilhalog.trilhalog.core.agendamento.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot;
import com.trilhalog.trilhalog.core.agendamento.entity.Doca;
import com.trilhalog.trilhalog.core.agendamento.mappers.AgendaSlotMapper;
import com.trilhalog.trilhalog.core.agendamento.repository.AgendaSlotRepository;
import com.trilhalog.trilhalog.core.exceptions.custom.AgendaSlotNotFoundException;


@Service
public class AgendaSlotServiceImpl implements AgendaSlotService {
	private final AgendaSlotMapper mapper;
	private final AgendaSlotRepository repository;
	private final DocaService docaService;

	public AgendaSlotServiceImpl(AgendaSlotMapper mapper, AgendaSlotRepository repository, DocaService docaService) {
		this.mapper = mapper;
		this.repository = repository;
		this.docaService = docaService;
	}

	@Override
	public AgendaSlotResponse cadastrar(AgendaSlotRequest request) {
		
		Doca doca = docaService.bucarPorIdEntity(request.docaId());		
		AgendaSlot agendaSlot = mapper.toAgendaSlot(request);		
		agendaSlot.setDoca(doca);		
		AgendaSlot agendaSlotSalvo = repository.save(agendaSlot);
		return mapper.toAgendaSlotResponse(agendaSlotSalvo);
		
	}

	@Override
	public AgendaSlotResponse editar(String id, AgendaSlotRequest request) {
		AgendaSlot agendaSlot = repository.findById(id).orElseThrow(AgendaSlotNotFoundException::new);
		BeanUtils.copyProperties(request, agendaSlot, "id");
		AgendaSlot agendaSlotEditado = repository.save(agendaSlot);
		return mapper.toAgendaSlotResponse(agendaSlotEditado);
	}

	@Override
	public void deletar(String id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		} else {
			throw new AgendaSlotNotFoundException("erro ao deletar");

		}
	}

	@Override
	public List<AgendaSlotResponse> listarTodos() {
		return repository.findAll().stream().map(mapper::toAgendaSlotResponse).toList();
	}

	@Override
	public AgendaSlotResponse buscarPorId(String id) {
		return repository.findById(id).map(mapper::toAgendaSlotResponse).orElseThrow(AgendaSlotNotFoundException::new);
	}

	@Override
	public AgendaSlot buscarPorIdEntidade(String id) {
		return repository.findById(id).orElseThrow(AgendaSlotNotFoundException::new);

	}

}
