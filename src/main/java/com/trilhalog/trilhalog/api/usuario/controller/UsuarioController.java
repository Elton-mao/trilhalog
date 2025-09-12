package com.trilhalog.trilhalog.api.usuario.controller;

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

import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResponse;
import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResquest;
import com.trilhalog.trilhalog.core.usuario.enums.StatusDoCadastroDoUsuario;
import com.trilhalog.trilhalog.core.usuario.services.UsuarioService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
			
	private final UsuarioService service;

	public UsuarioController(UsuarioService service) {
		super();
		this.service = service;
	}
	
	@GetMapping
	public List<UsuarioResponse> listarTodos() {
		 return service.listarTodos(); 
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UsuarioResponse cadastrar(@RequestBody @Valid UsuarioResquest request) {
	    System.out.println(request.transportadora());
		return service.cadastrar(request);
	}
	@PutMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public UsuarioResponse editar(@PathVariable  String id,@RequestBody UsuarioResquest request) {
		return service.editar(request, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deletar( @PathVariable  String id) {
		service.deletar(id);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public UsuarioResponse desativar(@PathVariable String id, @RequestBody StatusDoCadastroDoUsuario status) {
		return service.desativar(id, status); 
	}
	
	@GetMapping("/{id}")
	public UsuarioResponse buscarPorId(@PathVariable String id) {
		return service.buscarPorId(id);
	}
	
	
	
}
