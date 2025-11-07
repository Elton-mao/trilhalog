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

import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.AgendaSlotResponse;
import com.trilhalog.trilhalog.core.agendamento.service.AgendaSlotService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 
 * 
 * <p>Esta classe é anotada com {@link RestController}, expondo endpoints para
 * operações CRUD (Criar, Ler, Atualizar, Deletar) relacionadas aos slots de agenda.
 * O mapeamento base para as requisições é "/api/agendaslot".</p>
 * 
 * <p>Utiliza {@link AgendaSlotService} para a lógica de negócio e DTOs como
 * {@link AgendaSlotRequest} e {@link AgendaSlotResponse} para a comunicação.</p>
 */
@Tag(name="horários disponíveis",description="Controlador REST para gerenciar os slots de agenda (horários disponíveis).")
@RestController
@RequestMapping("api/agendaslot")
public class AgendaSlotController {
	private final AgendaSlotService service;

	/**
     * Construtor que injeta a dependência do serviço de slots de agenda.
     * 
     * @param service O serviço que gerencia a lógica de negócio dos slots de agenda.
     */
	public AgendaSlotController(AgendaSlotService service) {
		this.service = service;
	}


	@GetMapping
	@Operation(summary ="Retorna uma Lista de todos os horarios cadastrados")
	public List<AgendaSlotResponse> listarTodos(){
		return service.listarTodos();
	}
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary ="cadastra horarios disponives")
	public AgendaSlotResponse cadastrar(@RequestBody @Valid AgendaSlotRequest request) {
		return service.cadastrar(request);
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Operation(summary = "Atualiza um slot de agenda existente")
	public AgendaSlotResponse editar(@PathVariable String id, @RequestBody AgendaSlotRequest request) {
		return service.editar(id, request);
	}
	
	
	@GetMapping("/{id}")
	@Operation(summary ="Busca um slot de agenda pelo seu ID.")
	public AgendaSlotResponse buscarPorId(@PathVariable String id) {
		return service.buscarPorId(id);
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Operation(summary="Deleta um slot de agenda pelo seu ID.")
	public void deletar(@PathVariable String id) {
		service.deletar(id);

	}

}
