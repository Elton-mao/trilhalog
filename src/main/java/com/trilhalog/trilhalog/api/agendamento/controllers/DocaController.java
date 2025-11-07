package com.trilhalog.trilhalog.api.agendamento.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.agendamento.dtos.DocaRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.DocaResponse;
import com.trilhalog.trilhalog.core.agendamento.service.DocaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("api/doca")
@Tag(name ="Gerenciamento das Docas", description = "Controlador REST para gerenciar as docas. ")
public class DocaController {
	private final DocaService service;

	/**
     * Construtor que injeta a dependência do serviço de docas.
     * 
     * @param service O serviço responsável pela lógica de negócio das docas.
     */
	public DocaController(DocaService service) {
		this.service = service;
	}
 

	@GetMapping
	@Operation(summary ="Retorna uma lista de todas as docas cadastradas")
	public List<DocaResponse> listarTodos(){
		return service.listarTodos(); 
	}
	

	@PostMapping
	@Operation(summary ="Cadastra uma nova doca.")
	@ResponseStatus(code = HttpStatus.CREATED)
	public DocaResponse cadastrar(@RequestBody @Valid DocaRequest request) {
		return service.cadastrar(request);
	}

	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Operation(summary = "Atualiza uma doca existente.")
	public DocaResponse editar(@PathVariable String id, @RequestBody DocaRequest request) {
		return service.editar(id, request);
	}
    
    
    
	@GetMapping("/{id}")
	@Operation(summary ="Busca uma doca pelo seu ID.")
	public DocaResponse buscarPorid(@PathVariable String id) {
		return service.buscarPorid(id);
	}
}
