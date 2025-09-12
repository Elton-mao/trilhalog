package com.trilhalog.trilhalog.api.transportadora.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraRequest;
import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraResponse;
import com.trilhalog.trilhalog.core.transportadora.enums.StatusDoCadastroDaTransportadora;
import com.trilhalog.trilhalog.core.transportadora.services.TransportadoraService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/transportadora")
public class TransportadoraController {
	
	private final TransportadoraService service;
	
	public TransportadoraController(TransportadoraService service) {
		this.service = service;
	} 
	
	@GetMapping
	public List<TransportadoraResponse> listarTodos(){
		return service.listarTodos(); 
	}
	
	@GetMapping("/{id}")
	public TransportadoraResponse buscarPorId(@PathVariable String id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public TransportadoraResponse cadastrar(@RequestBody @Valid TransportadoraRequest request) {
		return service.cadastrar(request);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public TransportadoraResponse atualizar(@PathVariable String id, @RequestBody @Valid TransportadoraRequest request) {
		return service.editar(request, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable String id) {
		service.deletar(id);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public TransportadoraResponse desativarCadastro(@PathVariable String id, @RequestBody StatusDoCadastroDaTransportadora status) {
		return service.desativar(id, status);
}
	
	
}
