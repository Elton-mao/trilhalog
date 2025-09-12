package com.trilhalog.trilhalog.core.agendamento.mappers;

import org.springframework.stereotype.Component;

import com.trilhalog.trilhalog.api.agendamento.dtos.DocaRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.DocaResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Doca;
@Component
public class DocaMapperImpl implements DocaMapper{

	@Override
	public DocaResponse toDocaResponse(Doca response) {
		return new DocaResponse(
				response.getId(), 
				response.getNome()
				);
	}

	@Override
	public Doca toDoca(DocaRequest request) {
		return new Doca(request.nome());
	}

}
