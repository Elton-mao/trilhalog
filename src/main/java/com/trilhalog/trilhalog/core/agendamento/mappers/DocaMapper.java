package com.trilhalog.trilhalog.core.agendamento.mappers;


import com.trilhalog.trilhalog.api.agendamento.dtos.DocaRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.DocaResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Doca;


public interface DocaMapper {
	  DocaResponse toDocaResponse(Doca response);
	  Doca toDoca(DocaRequest request);
}
