package com.trilhalog.trilhalog.core.agendamento.service;

import java.util.List;

import com.trilhalog.trilhalog.api.agendamento.dtos.DocaRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.DocaResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Doca;

public interface DocaService {
	DocaResponse cadastrar(DocaRequest request);
	List<DocaResponse> listarTodos();
	DocaResponse editar(String id, DocaRequest request);
	DocaResponse buscarPorid(String id);
	Doca bucarPorIdEntity(String id);
	
}
