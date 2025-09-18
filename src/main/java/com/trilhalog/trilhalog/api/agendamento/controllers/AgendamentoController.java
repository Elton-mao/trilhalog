package com.trilhalog.trilhalog.api.agendamento.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendamentoResponse;
import com.trilhalog.trilhalog.core.agendamento.enums.StatusDoAgendamento;
import com.trilhalog.trilhalog.core.agendamento.repository.AgendamentoRepository;
import com.trilhalog.trilhalog.core.agendamento.service.AgendamentoService;


@RestController
@RequestMapping("/api/agendamento")
public class AgendamentoController {

	private final AgendamentoService service;
	private final AgendamentoRepository repository;

	public AgendamentoController(AgendamentoService service,AgendamentoRepository repository) {
		this.service = service;
		this.repository = repository;
	}

	@GetMapping
	public List<AgendamentoResponse> buscarTodos() {
		return service.buscarTodos();
		
		}
	
	@GetMapping("/{id}")
	public String buscarteste(@PathVariable String id) {
		System.out.println(repository.findAll());
		return "ok";
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AgendamentoResponse agendar(@RequestBody AgendamentoRequest request) {
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
