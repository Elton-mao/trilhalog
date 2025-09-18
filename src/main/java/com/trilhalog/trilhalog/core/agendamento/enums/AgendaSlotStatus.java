package com.trilhalog.trilhalog.core.agendamento.enums;

public enum AgendaSlotStatus {


	    DISPONIVEL("Disponível"),
	    ESGOTANDO("Esgotando"),
	    ESGOTADO("Esgotado"),
	    CANCELADO("Cancelado"),
	    INATIVO("Inativo");

	    private final String descricao;

	    AgendaSlotStatus(String descricao) {
	        this.descricao = descricao;
	    }

	    public String getDescricao() {
	        return descricao;
	    }
	}


