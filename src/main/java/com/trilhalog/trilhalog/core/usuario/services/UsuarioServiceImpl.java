package com.trilhalog.trilhalog.core.usuario.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResponse;
import com.trilhalog.trilhalog.api.usuario.dto.UsuarioResquest;
import com.trilhalog.trilhalog.core.exceptions.custom.UsuarioNotFoundException;
import com.trilhalog.trilhalog.core.transportadora.entity.Transportadora;
import com.trilhalog.trilhalog.core.transportadora.services.TransportadoraService;
import com.trilhalog.trilhalog.core.usuario.entity.Usuario;
import com.trilhalog.trilhalog.core.usuario.enums.StatusDoCadastroDoUsuario;
import com.trilhalog.trilhalog.core.usuario.mappers.UsuarioMapper;
import com.trilhalog.trilhalog.core.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioMapper mapper;

	private final UsuarioRepository repository;
	
	private final TransportadoraService transportadoraService; 

	

	public UsuarioServiceImpl(UsuarioMapper mapper, UsuarioRepository repository,
			TransportadoraService transportadoraService) {
		
		this.mapper = mapper;
		this.repository = repository;
		this.transportadoraService = transportadoraService;
	}

	@Override
	public List<UsuarioResponse> listarTodos() {
		return repository.findAll()
				.stream()
				.map(mapper::toUsuarioResponse)
				.toList(); 
	}

	@Override
	public UsuarioResponse cadastrar(UsuarioResquest request) {
		Transportadora transportadora = transportadoraService.buscarPorIdEntidade(request.transportadora()); 
		Usuario novoUsuario = mapper.toUsuario(request);
		novoUsuario.setTransportadora(transportadora);
		novoUsuario.setStatus(StatusDoCadastroDoUsuario.ATIVO);
		Usuario UsuarioSalvo = repository.save(novoUsuario);
		return mapper.toUsuarioResponse(UsuarioSalvo);
	}

	@Override
	public UsuarioResponse editar(UsuarioResquest request, String id) {
		Usuario usuario = repository.findById(id).orElseThrow(UsuarioNotFoundException::new);
		BeanUtils.copyProperties( request,usuario, "id");
		Usuario usuarioAtualizado = usuario; 
		return mapper.toUsuarioResponse(usuarioAtualizado);
	}

	@Override
	public void deletar(String id) {
		Usuario usuario = repository.findById(id).orElseThrow(UsuarioNotFoundException::new);
		repository.delete(usuario);
	}

	@Override
	public UsuarioResponse desativar(String id, StatusDoCadastroDoUsuario status) {
		Usuario usuario = repository.findById(id).orElseThrow(UsuarioNotFoundException::new);
		usuario.setStatus(status);
		Usuario usuarioDesativado = repository.save(usuario);
		return mapper.toUsuarioResponse(usuarioDesativado);
	}

	@Override
	public UsuarioResponse buscarPorId(String id) {
		return repository.findById(id).map(mapper::toUsuarioResponse).orElseThrow(UsuarioNotFoundException::new);
	}

}
