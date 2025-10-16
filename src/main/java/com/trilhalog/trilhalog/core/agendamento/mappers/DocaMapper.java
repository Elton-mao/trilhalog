package com.trilhalog.trilhalog.core.agendamento.mappers;


import com.trilhalog.trilhalog.api.agendamento.dtos.DocaRequest;
import com.trilhalog.trilhalog.api.agendamento.dtos.DocaResponse;
import com.trilhalog.trilhalog.core.agendamento.entity.Doca;

/**
 * Interface para o mapeamento entre a entidade Doca e seus DTOs (Data Transfer Objects).
 * 
 * <p>Define o contrato para a conversão de objetos relacionados a docas,
 * desacoplando a representação interna da externa.</p>
 */
public interface DocaMapper {
    /**
     * Converte uma entidade {@link Doca} em um DTO {@link DocaResponse}.
     * 
     * @param response A entidade a ser convertida.
     * @return O DTO correspondente com os dados a serem expostos pela API.
     */
	  DocaResponse toDocaResponse(Doca response);
	  
    /**
     * Converte um DTO {@link DocaRequest} em uma entidade {@link Doca}.
     * 
     * @param request O DTO com os dados de entrada.
     * @return A entidade pronta para ser persistida ou processada.
     */
	  Doca toDoca(DocaRequest request);
}
