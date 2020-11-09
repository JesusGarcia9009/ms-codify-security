package com.ms.codify.exception;

/**
 * Excepcion para manejar que el Usuario no esta autenticado
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
public class UserNotAuthException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String erroHandle;

    public static UserNotAuthException createWith(String erroHandle) {
        return new UserNotAuthException(erroHandle);
    }

    public UserNotAuthException(String erroHandle) {
        this.erroHandle = erroHandle;
    }

    @Override
    public String getMessage() {
        return erroHandle;
    }
}
