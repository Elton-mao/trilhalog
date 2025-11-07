package com.trilhalog.trilhalog.api.transportadora.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraRequest;
import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraResponse;
import com.trilhalog.trilhalog.core.transportadora.enums.StatusDoCadastroDaTransportadora;
import com.trilhalog.trilhalog.core.transportadora.services.TransportadoraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/transportadora")
@Tag(name ="Gerenciamento das Transportadoras",description ="Controlador REST para  Gerenciamento das Transportadoras")
public class TransportadoraController {
	
	private final TransportadoraService service;
	
	public TransportadoraController(TransportadoraService service) {
		this.service = service;
	} 
	
	@GetMapping
	@Operation(summary="Retorna uma Lista com Todas as Transportadoras Cadastradas")
	public List<TransportadoraResponse> listarTodos(){
		return service.listarTodos(); 
	}
	
	@GetMapping("/{id}")
	@Operation(summary="busca uma Transportadora por seu ID")
	public TransportadoraResponse buscarPorId(@PathVariable String id) {
		return service.buscarPorId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary="Cadastra uma Nova Transportadora")
	public TransportadoraResponse cadastrar(@RequestBody @Valid TransportadoraRequest request) {
		return service.cadastrar(request);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Operation(summary ="Atualiza Uma Transportadora Existente")
	public TransportadoraResponse atualizar(@PathVariable String id, @RequestBody @Valid TransportadoraRequest request) {
		return service.editar(request, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Operation(summary = "Deleta uma transportadora Pelo Seu ID")
	public void excluir(@PathVariable String id) {
		service.deletar(id);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Operation(summary = "Desativa um Cadastro de Transportadora pelo seu ID")
	public TransportadoraResponse desativarCadastro(@PathVariable String id, @RequestBody StatusDoCadastroDaTransportadora status) {
		return service.desativar(id, status);
}
	
	
}
