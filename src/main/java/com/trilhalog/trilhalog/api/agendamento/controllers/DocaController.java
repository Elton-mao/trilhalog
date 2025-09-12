package com.trilhalog.trilhalog.api.agendamento.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.agendamento.dtos.DocaRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.DocaResponse;
import com.trilhalog.trilhalog.core.agendamento.service.DocaService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/doca")
public class DocaController {
	private final DocaService service;

	public DocaController(DocaService service) {
		this.service = service;
	}
 
	@GetMapping
	public List<DocaResponse> listarTodos(){
		return service.listarTodos(); 
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DocaResponse cadastrar(@RequestBody @Valid DocaRequest request) {
		return service.cadastrar(request);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public DocaResponse editar(@PathVariable String id, @RequestBody DocaRequest request) {
		return service.editar(id, request);
	}
	@GetMapping("/{id}")
	public DocaResponse buscarPorid(@PathVariable String id) {
		return service.buscarPorid(id);
	}

	
	
	
	
	
	
	
	
	
	
	
}
