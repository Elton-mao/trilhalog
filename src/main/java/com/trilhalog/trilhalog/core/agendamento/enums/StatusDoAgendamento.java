package com.trilhalog.trilhalog.core.agendamento.enums;

/**
 * Enum que representa os possíveis status de um {@link com.trilhalog.trilhalog.core.agendamento.entity.Agendamento}.
 */
public enum StatusDoAgendamento {
	/**
	 * O agendamento foi criado mas está pendente de alguma ação ou confirmação.
	 */
	PEDENTE,
	
	/**
	 * O agendamento foi concluído com sucesso.
	 */
	FINALIZADO,
	
	/**
	 * O agendamento foi cancelado.
	 */
	CANCELADO
}
