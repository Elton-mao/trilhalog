package com.trilhalog.trilhalog.core.transportadora.services;

import java.util.List;

import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraRequest;
import com.trilhalog.trilhalog.api.transportadora.dtos.TransportadoraResponse;
import com.trilhalog.trilhalog.core.transportadora.entity.Transportadora;
import com.trilhalog.trilhalog.core.transportadora.enums.StatusDoCadastroDaTransportadora;

public interface TransportadoraService {
	List<TransportadoraResponse> listarTodos(); 
	TransportadoraResponse cadastrar(TransportadoraRequest request);
	TransportadoraResponse editar(TransportadoraRequest request,String id); 
	TransportadoraResponse buscarPorId(String id);
	Transportadora buscarPorIdEntidade(String id); 
	void deletar(String id);
	TransportadoraResponse desativar(String id,StatusDoCadastroDaTransportadora status); 
}
