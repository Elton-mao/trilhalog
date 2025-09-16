package com.trilhalog.trilhalog.core.agendamento.service;

import org.springframework.stereotype.Service;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Agendamento;
import com.trilhalog.trilhalog.core.agendamento.enums.StatusDoAgendamento;
import com.trilhalog.trilhalog.core.agendamento.mappers.AgendamentoMapper;
import com.trilhalog.trilhalog.core.agendamento.repository.AgendamentoRepository;
import com.trilhalog.trilhalog.core.exceptions.custom.AgendamentoNotFoundException;
import com.trilhalog.trilhalog.core.usuario.services.UsuarioService;

@Service
public class AgendamentoServiceImpl implements AgendamentoService{
	
	private final UsuarioService usuarioService;
	private final AgendamentoMapper agendamentoMapper;
	private final AgendaSlotService agendaSlotService;
	private final AgendamentoRepository repository; 
	
	public AgendamentoServiceImpl(AgendamentoRepository repository, UsuarioService usuarioService,

			AgendamentoMapper agendamentoMapper, AgendaSlotService agendaSlotService) {
		super();
		this.repository = repository;
		this.usuarioService = usuarioService;
		this.agendamentoMapper = agendamentoMapper;
		this.agendaSlotService = agendaSlotService;
	}

	@Override
	public AgendamentoResponse agendar(AgendamentoRequest request) {
		
		Agendamento agendamento = agendamentoMapper.toAgendamento(request); 
		agendamento.setUsuario(usuarioService.buscarPorIdObjeto(request.usuario()));
		agendamento.setAgendaSlot(agendaSlotService.buscarPorIdEntidade(request.agendaSlot()));
		agendamento.setStatus(StatusDoAgendamento.PEDENTE);
		Agendamento agendamentoSalvo =  repository.save(agendamento); 
		return agendamentoMapper.toAgendamentoResponse(agendamentoSalvo);
		
	}

	@Override
	public void deletar(String id) {
		Agendamento agendamento = repository.findById(id).orElseThrow(AgendamentoNotFoundException::new); 
		repository.delete(agendamento);
		
	}

	@Override
	public void alterarStatus(String id,StatusDoAgendamento status) {
		Agendamento agendamento = repository.findById(id).orElseThrow(AgendamentoNotFoundException::new); 
		agendamento.setStatus(status);
	}

}
