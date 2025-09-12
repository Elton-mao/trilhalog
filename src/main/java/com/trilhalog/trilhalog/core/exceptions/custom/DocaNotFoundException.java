package com.trilhalog.trilhalog.core.exceptions.custom;

public class DocaNotFoundException extends ModelNotFoundExeceptions{

	public DocaNotFoundException() {
		super("Doca não encontrada favor verifique o ID Informado");
		// TODO Auto-generated constructor stub
	}
	
	public DocaNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
