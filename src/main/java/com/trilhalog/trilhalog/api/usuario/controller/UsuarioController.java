package com.trilhalog.trilhalog.api.usuario.controller;

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

import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResponse;
import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResquest;
import com.trilhalog.trilhalog.core.usuario.enums.StatusDoCadastroDoUsuario;
import com.trilhalog.trilhalog.core.usuario.services.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/usuario")
@Tag(name ="Gerenciamento de Usuarios",description ="Controlador REST para gerenciamento de Usuarios ")
public class UsuarioController {
			
	private final UsuarioService service;

	public UsuarioController(UsuarioService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	@Operation(summary="Retorna uma Lista com Todos Usuarios Cadastrados")
	public List<UsuarioResponse> listarTodos() {
		 return service.listarTodos(); 
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@Operation(summary="Cadastra um novo Usuario")
	public UsuarioResponse cadastrar(@RequestBody @Valid UsuarioResquest request) {
		return service.cadastrar(request);
	}
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Operation(summary="Atualiza Cadastro do Usuario")
	public UsuarioResponse editar(@PathVariable  String id,@RequestBody UsuarioResquest request) {
		return service.editar(request, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Operation(summary="deleta um Usuario por seu ID")
	public void deletar( @PathVariable  String id) {
		service.deletar(id);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@Operation(summary = "desativa um Usuario Por seu ID")
	public UsuarioResponse desativar(@PathVariable String id, @RequestBody StatusDoCadastroDoUsuario status) {
		return service.desativar(id, status); 
	}
	
	@GetMapping("/{id}")
	@Operation(summary="buscar um Usuario por seu ID")
	public UsuarioResponse buscarPorId(@PathVariable String id) {
		return service.buscarPorId(id);
	}
	
	
	
}
