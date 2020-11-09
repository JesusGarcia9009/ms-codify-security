package com.ms.codify.enums;


/**
 * KeyClaimsTokenEnum - Claims_Token - Spring Boot
 *
 * @author Jesus Garcia
 * @version jdk-11
 */
public enum KeyClaimsTokenEnum {
	
	ID_USUARIO("idUsuario"),
	FULL_NAME("fullName"),
	USERNAME("username"),
	AUTHORITIES("authorities"),
	ROLES("roles"),
	RUT("rut"),
	PERFILES("perfiles"),
	APLICACIONES("aplicaciones");
	
	private String descripcion;
	
	KeyClaimsTokenEnum(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
