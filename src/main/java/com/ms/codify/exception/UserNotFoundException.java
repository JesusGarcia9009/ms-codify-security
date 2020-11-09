package com.ms.codify.exception;

/**
 * Excepcion para manejar que el Usuario no fue encontrado en la base de datos
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
public class UserNotFoundException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;

    public static UserNotFoundException createWith(String username) {
        return new UserNotFoundException(username);
    }

    private UserNotFoundException(String username) {
        this.username = username;
    }

    @Override
    public String getMessage() {
        return "Usuario '" + username + "' no encontrado";
    }
}
