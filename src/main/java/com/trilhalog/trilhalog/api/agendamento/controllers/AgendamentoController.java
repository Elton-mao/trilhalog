package com.trilhalog.trilhalog.api.agendamento.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.core.agendamento.enums.StatusDoAgendamento;
import com.trilhalog.trilhalog.core.agendamento.service.AgendamentoService;


@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoController {

	private final AgendamentoService service;

	public AgendamentoController(AgendamentoService service) {
		this.service = service;
	}

	@GetMapping
	public List<AgendamentoResponse> buscarTodos() {
		return service.buscarTodos();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AgendamentoResponse agendar(@RequestBody AgendamentoRequest request) {
		System.out.println("id da agenda slot debug"+request.agendaSlot());
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
