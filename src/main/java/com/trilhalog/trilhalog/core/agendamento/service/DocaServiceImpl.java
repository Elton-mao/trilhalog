package com.trilhalog.trilhalog.core.agendamento.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.trilhalog.trilhalog.api.agendamento.dtos.DocaRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.DocaResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Doca;
import com.trilhalog.trilhalog.core.agendamento.mappers.DocaMapper;
import com.trilhalog.trilhalog.core.agendamento.repository.DocaRepository;
import com.trilhalog.trilhalog.core.exceptions.custom.DocaNotFoundException;

@Service
public class DocaServiceImpl implements DocaService {

	private final DocaMapper mapper;
	private final DocaRepository repository;

	public DocaServiceImpl(DocaMapper mapper, DocaRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public DocaResponse cadastrar(DocaRequest request) {
		Doca doca = mapper.toDoca(request);
		Doca response = repository.save(doca);
		return mapper.toDocaResponse(response);
	}

	@Override
	public List<DocaResponse> listarTodos() {
		return repository.findAll().stream().map(mapper::toDocaResponse).toList();
	}

	@Override
	public DocaResponse editar(String id, DocaRequest request) {
		Doca doca = repository.findById(id).orElseThrow(DocaNotFoundException::new);
		BeanUtils.copyProperties(request, doca, "id");
		Doca response = repository.save(doca);
		return mapper.toDocaResponse(response);
	}

	@Override
	public DocaResponse buscarPorid(String id) {
		return repository.findById(id).map(mapper::toDocaResponse).orElseThrow(DocaNotFoundException::new);
	}

	@Override
	public Doca bucarPorIdEntity(String id) {
		return repository.findById(id).orElseThrow(DocaNotFoundException::new);
	}

	

}
