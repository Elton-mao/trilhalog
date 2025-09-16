package com.trilhalog.trilhalog.core.exceptions.custom;

public class AgendamentoNotFoundException extends ModelNotFoundExeceptions{

	public AgendamentoNotFoundException() {
		super("agendamento não encontrada");
		// TODO Auto-generated constructor stub
	}
	
	public AgendamentoNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
