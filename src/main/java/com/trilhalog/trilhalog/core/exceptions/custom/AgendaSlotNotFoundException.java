package com.trilhalog.trilhalog.core.exceptions.custom;

public class AgendaSlotNotFoundException extends ModelNotFoundExeceptions{

	public AgendaSlotNotFoundException() {
		super("Slot de Agenda não encontrada");
		// TODO Auto-generated constructor stub
	}
	
	public AgendaSlotNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
