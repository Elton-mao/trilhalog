package com.trilhalog.trilhalog.core.transportadora.mappers;

import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraRequest;
import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraResponse;
import com.trilhalog.trilhalog.core.transportadora.entity.Transportadora;

public interface TransportadoraMapper {
	
	TransportadoraResponse toTransportadoraResponse(Transportadora response);
	
	Transportadora toTransportadora(TransportadoraRequest request);
}
