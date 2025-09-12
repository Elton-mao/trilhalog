package com.trilhalog.trilhalog.core.exceptions.custom;

public class TransportadoraNotFoundException extends ModelNotFoundExeceptions{

	public TransportadoraNotFoundException() {
		super("Transportadora não encontrada favor verifique o ID Informado");
		// TODO Auto-generated constructor stub
	}
	
	public TransportadoraNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
