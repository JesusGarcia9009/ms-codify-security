package com.ms.codify.exception;

/**
 * NotFoundException - Excepcion para manejar el no encontrar resultados en la base de datos
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String value;

	public static NotFoundException createWith(String dependecy) {
		return new NotFoundException(dependecy);
	}

	private NotFoundException(String dependecy) {
		this.value = dependecy;
	}

	@Override
	public String getMessage() {
		return "Elemento '" + value + "' no encontrado";
	}

}
