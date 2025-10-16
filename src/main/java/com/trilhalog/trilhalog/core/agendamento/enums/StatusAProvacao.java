package com.trilhalog.trilhalog.core.agendamento.enums;

/**
 * Enum que representa os possíveis status de um processo de aprovação.
 * 
 * <p>Pode ser usado para aprovação de cadastros, agendamentos, etc.</p>
 */
public enum StatusAProvacao {
	/**
	 * O item está em análise, aguardando uma decisão.
	 */
	ANALISE,
	
	/**
	 * O item foi aprovado.
	 */
	APROVADO,
	
	/**
	 * O item foi reprovado.
	 */
	REPROVADO
}
