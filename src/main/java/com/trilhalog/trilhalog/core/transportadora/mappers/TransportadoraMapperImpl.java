package com.trilhalog.trilhalog.core.transportadora.mappers;

import org.springframework.stereotype.Component;

import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraRequest;
import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraResponse;
import com.trilhalog.trilhalog.core.transportadora.entity.Transportadora;

@Component
public class TransportadoraMapperImpl implements TransportadoraMapper{

	@Override
	public TransportadoraResponse toTransportadoraResponse(Transportadora response) {
		return new TransportadoraResponse(
				response.getCnpj(), 
				response.getRazaoSocial(), 
				response.getDataDoCadastro(), 
				response.getStatusDoCadastro());
	}

	@Override
	public Transportadora toTransportadora(TransportadoraRequest request) {
		return new Transportadora( 
				request.cnpj(), 
				request.razaoSocial());	
	}

}
