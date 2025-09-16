package com.trilhalog.trilhalog.api.agendamento.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.core.agendamento.enums.StatusDoAgendamento;
import com.trilhalog.trilhalog.core.agendamento.service.AgendamentoService;

@RestController
@RequestMapping("/api/agendamento")
public class AgendaController {

	private final AgendamentoService service;

	public AgendaController(AgendamentoService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AgendamentoResponse agendar(AgendamentoRequest request) {
		return service.agendar(request);
	}

	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(String id) {
		service.deletar(id);
	}
	
	@PutMapping
	public void alterarStatus(String id, StatusDoAgendamento status) {
		service.alterarStatus(id, status);
	}

}
