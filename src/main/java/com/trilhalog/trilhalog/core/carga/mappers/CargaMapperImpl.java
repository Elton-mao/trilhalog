package com.trilhalog.trilhalog.core.carga.mappers;

import org.springframework.stereotype.Component;

import com.trilhalog.trilhalog.api.carga.dtos.CargaRequest;
import com.trilhalog.trilhalog.api.carga.dtos.CargaResponse;
import com.trilhalog.trilhalog.core.carga.entity.Carga;

@Component
public class CargaMapperImpl implements CargaMapper{

	@Override
	public Carga toCarga(CargaRequest request) {
		return new Carga(request.descricao(), request.observacao(), request.quantidade());
	}

	@Override
	public CargaResponse toCargaResponse(Carga carga) {
		return new CargaResponse(carga.getId(), carga.getDescricao(), carga.getObservacao(), carga.getQuantidade());
	}

}
