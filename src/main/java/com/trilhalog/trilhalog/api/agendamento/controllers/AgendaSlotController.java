package com.trilhalog.trilhalog.api.agendamento.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotResponse;
import com.trilhalog.trilhalog.core.agendamento.service.AgendaSlotService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/agendaslot")
public class AgendaSlotController {
	private final AgendaSlotService service;

	public AgendaSlotController(AgendaSlotService service) {
		this.service = service;
	}

	@GetMapping
	public List<AgendaSlotResponse> listarTodos(){
		return service.listarTodos();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AgendaSlotResponse cadastrar(@RequestBody @Valid AgendaSlotRequest request) {
		return service.cadastrar(request);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public AgendaSlotResponse editar(@PathVariable String id, @RequestBody AgendaSlotRequest request) {
		return service.editar(id, request);
	}
	
	@GetMapping("/{id}")
	public AgendaSlotResponse buscarPorId(@PathVariable String id) {
		return service.buscarPorId(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable String id) {
		service.deletar(id);

	}

}
