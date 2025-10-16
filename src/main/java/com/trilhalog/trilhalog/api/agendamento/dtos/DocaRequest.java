package com.trilhalog.trilhalog.api.agendamento.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO (Data Transfer Object) para a criação ou atualização de uma doca.
 * 
 * <p>Este record encapsula o nome da doca a ser criada ou atualizada. Inclui validações
 * para garantir que o nome não seja vazio e tenha um tamanho mínimo.</p>
 * 
 * <p>É mapeado para a entidade {@link com.trilhalog.trilhalog.core.agendamento.entity.Doca}.</p>
 * 
 * @param nome O nome da doca. Não pode ser branco e deve ter no mínimo 2 caracteres.
 */
public record DocaRequest(
		@NotBlank(message = "{doca.nome.NotBlank}")
		@Size(min = 2, message ="{doca.nome.Size}" )
		String nome
		) {
}
