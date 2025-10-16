package com.trilhalog.trilhalog.api.agendamento.dtos;

/**
 * DTO (Data Transfer Object) para a resposta de uma doca.
 * 
 * <p>Este record encapsula os dados de uma doca a serem enviados em uma resposta de API.
 * É mapeado a partir da entidade {@link com.trilhalog.trilhalog.core.agendamento.entity.Doca}.</p>
 * 
 * @param id O identificador único da doca.
 * @param nome O nome da doca.
 */
public record DocaResponse(String id, String nome) {

}
