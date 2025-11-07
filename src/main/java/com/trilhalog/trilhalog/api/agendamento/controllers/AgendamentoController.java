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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador REST para gerenciar agendamentos.
 * 
 * <p>Esta classe é anotada com {@link RestController}, o que a torna um bean do Spring
 * que lida com requisições HTTP. O mapeamento base para as requisições é "/api/agendamento",
 * definido pela anotação {@link RequestMapping}.</p>
 * 
 * <p>Este controlador utiliza {@link AgendamentoService} para a lógica de negócio
 * e se comunica com o cliente através de DTOs como {@link AgendamentoRequest} e
 * {@link AgendamentoResponse}.</p>
 */
@RestController
@RequestMapping("/api/agendamento")
@Tag(name ="Gerenciar agendamentos", description="Controlador REST para gerenciamento dos agendamentos")
public class AgendamentoController {

	private final AgendamentoService service;
	

	/**
     * Construtor para injeção de dependências do serviço de agendamento e repositório.
     * 
     * @param service O serviço que implementa a lógica de negócio para agendamentos.
     * @param repository O repositório para acesso direto aos dados, usado para fins de teste.
     */
	public AgendamentoController(AgendamentoService service) {
		this.service = service;
		
	}


	@GetMapping
	@Operation(summary ="Retorna uma lista de todos os agendamentos")
	public List<AgendamentoResponse> buscarTodos() {
		return service.buscarTodos();
		
		}
	

 
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary="Cria um novo agendamento")
	public AgendamentoResponse agendar(@RequestBody AgendamentoRequest request) {
		return service.agendar(request);
	}

	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Operation(summary ="Deleta um agendamento pelo seu ID")
	public void deletar(String id) {
		service.deletar(id);
	}

	
	@PutMapping
	@Operation(summary = "Altera o status de um agendamento existente")
	public void alterarStatus(String id, StatusDoAgendamento status) {
		service.alterarStatus(id, status);
	}

}
