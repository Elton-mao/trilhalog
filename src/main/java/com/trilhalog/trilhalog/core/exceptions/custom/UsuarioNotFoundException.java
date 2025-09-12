package com.trilhalog.trilhalog.core.exceptions.custom;

public class UsuarioNotFoundException extends ModelNotFoundExeceptions{

	public UsuarioNotFoundException() {
		super("Usuario Não Encontrado por favor verifique o ID Informado");
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
