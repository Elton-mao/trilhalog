package com.trilhalog.trilhalog.core.carga.mappers;

import com.trilhalog.trilhalog.api.carga.dtos.CargaRequest;
import com.trilhalog.trilhalog.api.carga.dtos.CargaResponse;
import com.trilhalog.trilhalog.core.carga.entity.Carga;

public interface CargaMapper {
	Carga toCarga(CargaRequest request);
	CargaResponse toCargaResponse(Carga carga);
}
