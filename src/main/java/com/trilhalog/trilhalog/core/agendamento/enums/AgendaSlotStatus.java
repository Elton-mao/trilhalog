package com.trilhalog.trilhalog.core.agendamento.enums;

/**
 * Enum que representa os possíveis status de um slot de agenda ({@link com.trilhalog.trilhalog.core.agendamento.entity.AgendaSlot}).
 */
public enum AgendaSlotStatus {

    /**
     * O slot está disponível para novos agendamentos.
     */
    DISPONIVEL("Disponível"),
    
    /**
     * O slot tem poucas vagas restantes.
     */
    ESGOTANDO("Esgotando"),
    
    /**
     * Todas as vagas do slot foram preenchidas.
     */
    ESGOTADO("Esgotado"),
    
    /**
     * O slot foi cancelado e não pode ser usado.
     */
    CANCELADO("Cancelado"),
    
    /**
     * O slot está inativo e não disponível para agendamentos.
     */
    INATIVO("Inativo");

    private final String descricao;

    /**
     * Construtor do enum.
     * @param descricao A descrição textual do status.
     */
    AgendaSlotStatus(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição do status.
     * @return A descrição textual.
     */
    public String getDescricao() {
        return descricao;
    }
}
