package com.trilhalog.trilhalog.core.transportadora.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraRequest;
import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraResponse;
import com.trilhalog.trilhalog.core.exceptions.custom.TransportadoraNotFoundException;
import com.trilhalog.trilhalog.core.transportadora.entity.Transportadora;
import com.trilhalog.trilhalog.core.transportadora.enums.StatusDoCadastroDaTransportadora;
import com.trilhalog.trilhalog.core.transportadora.mappers.TransportadoraMapper;
import com.trilhalog.trilhalog.core.transportadora.repositories.TransportadoraRepository;

@Service
public class TransportadoraServiceImpl implements TransportadoraService {

	private final TransportadoraRepository repository;
	private final TransportadoraMapper mapper;

	public TransportadoraServiceImpl(TransportadoraRepository repository, TransportadoraMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public List<TransportadoraResponse> listarTodos() {

		return repository.findAll().stream().map(mapper::toTransportadoraResponse).toList();
	}

	@Override
	public TransportadoraResponse cadastrar(TransportadoraRequest request) {

		Transportadora novaTransportadora = mapper.toTransportadora(request);
		novaTransportadora.setStatusDoCadastro(StatusDoCadastroDaTransportadora.ATIVO);
		novaTransportadora.setDataDoCadastro(LocalDateTime.now());
		Transportadora transportadoraSalva = repository.save(novaTransportadora);

		return mapper.toTransportadoraResponse(transportadoraSalva);
	}

	@Override
	public TransportadoraResponse editar(TransportadoraRequest request, String id) {

		Transportadora transportadora = repository.findById(id)
				.orElseThrow(TransportadoraNotFoundException:: new);

		BeanUtils.copyProperties(request, transportadora, "id");

		Transportadora transportadoraAtualizada = repository.save(transportadora);

		return mapper.toTransportadoraResponse(transportadoraAtualizada);

	}

	@Override
	public TransportadoraResponse buscarPorId(String id) {
		return repository.findById(id).map(mapper::toTransportadoraResponse).orElseThrow(TransportadoraNotFoundException:: new);
	}

	@Override
	public void deletar(String id) {
		Transportadora trasportadora = repository.findById(id).orElseThrow(TransportadoraNotFoundException:: new);
		repository.delete(trasportadora);
	}

	@Override
	public TransportadoraResponse desativar(String id,StatusDoCadastroDaTransportadora status) {
		Transportadora transportadoraADesativada = repository.findById(id)
				.orElseThrow(TransportadoraNotFoundException:: new);
		transportadoraADesativada.setStatusDoCadastro(status);
		return mapper.toTransportadoraResponse(transportadoraADesativada);
		
	}

	@Override
	public Transportadora buscarPorIdEntidade(String id) {
		return repository.findById(id)
				.orElseThrow(TransportadoraNotFoundException:: new);
	}

}
