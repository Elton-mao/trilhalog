package com.trilhalog.trilhalog.core.agendamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot;
import com.trilhalog.trilhalog.core.agendamento.entity.Agendamento;
import com.trilhalog.trilhalog.core.agendamento.enums.StatusDoAgendamento;
import com.trilhalog.trilhalog.core.agendamento.mappers.AgendamentoMapper;
import com.trilhalog.trilhalog.core.agendamento.repository.AgendamentoRepository;
import com.trilhalog.trilhalog.core.carga.entity.Carga;
import com.trilhalog.trilhalog.core.carga.mappers.CargaMapper;
import com.trilhalog.trilhalog.core.exceptions.custom.AgendaSlotNotFoundException;
import com.trilhalog.trilhalog.core.exceptions.custom.AgendamentoNotFoundException;
import com.trilhalog.trilhalog.core.usuario.services.UsuarioService;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

	private final UsuarioService usuarioService;
	private final AgendamentoMapper agendamentoMapper;
	private final AgendaSlotService agendaSlotService;
	private final AgendamentoRepository repository;
	private final CargaMapper cargaMapper;

	public AgendamentoServiceImpl(AgendamentoRepository repository, UsuarioService usuarioService,

			AgendamentoMapper agendamentoMapper, AgendaSlotService agendaSlotService, CargaMapper cargaMapper) {
		this.repository = repository;
		this.usuarioService = usuarioService;
		this.agendamentoMapper = agendamentoMapper;
		this.agendaSlotService = agendaSlotService;
		this.cargaMapper = cargaMapper;
	}

	@Override
	public List<AgendamentoResponse> buscarTodos() {
		return  repository.findAll()
				.stream()
				.map(agendamentoMapper::toAgendamentoResponse).toList();
		
	}

	@Override
	public AgendamentoResponse agendar(AgendamentoRequest request) {

		Agendamento agendamento = agendamentoMapper.toAgendamento(request);
		agendamento.setUsuario(usuarioService.buscarPorIdObjeto(request.usuario()));
		AgendaSlot agendaSlot = agendaSlotService.buscarPorIdEntidade(request.agendaSlot());
		Carga carga = cargaMapper.toCarga(request.carga());
        if(agendaSlot.getVagasDisponiveis() <=0) {
        	throw new AgendaSlotNotFoundException("não ha vagas Disponiveis para este horário");
        }
		agendamento.setStatus(StatusDoAgendamento.PEDENTE);
		agendamento.setCarga(carga);
		agendamento.setAgendaSlot(agendaSlot);
		agendaSlot.setVagasDisponiveis(agendaSlot.getVagasDisponiveis() - 1);
		Agendamento agendamentoSalvo = repository.save(agendamento);
		return agendamentoMapper.toAgendamentoResponse(agendamentoSalvo);

	}

	@Override
	public void deletar(String id) {
		Agendamento agendamento = repository.findById(id).orElseThrow(AgendamentoNotFoundException::new);
		repository.delete(agendamento);

	}

	@Override
	public void alterarStatus(String id, StatusDoAgendamento status) {
		Agendamento agendamento = repository.findById(id).orElseThrow(AgendamentoNotFoundException::new);
		agendamento.setStatus(status);
	}

}
