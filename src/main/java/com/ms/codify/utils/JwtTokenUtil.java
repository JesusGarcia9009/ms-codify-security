package com.ms.codify.utils;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ms.codify.config.JwtTokenProvider;
import com.ms.codify.dto.CodifyUserDto;
import com.ms.codify.entities.UsuarioModel;
import com.ms.codify.exception.UserNotAuthException;

import lombok.extern.slf4j.Slf4j;


/**
 * Componentes pqara decompilar el token de usuario
 * 
 * @author Jesus Garcia
 * @version 1.0 Creacion
 * @since Java 11
 */
@Slf4j
@Component
public class JwtTokenUtil {

	@Autowired
	public AuthenticationManager authenticationManager;

	@Autowired
	public JwtTokenProvider tokenProvider;

	/**
	 * Crea el token cuando se loguea el usuario
	 * 
	 * @param username
	 * @param password
	 * @return data del usuario
	 */
	public Authentication createToken(String usernameOrEmail, String password) {
		log.info("[refreshToken]:: Inicio del metodo ");
		
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(usernameOrEmail, password));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		log.info("[refreshToken]:: Fin del metodo ");
		return authentication;
	}

	/**
	 * Refresca el token ante una modificacion
	 * 
	 * @param usuario
	 * @return
	 */
	public String refreshToken(UsuarioModel usuario) throws UserNotAuthException {
		log.info("[refreshToken] :: Inicio del metodo ");
		String jwt ="";
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			// Obtenemos los datos
			CodifyUserDto codifyUser = (CodifyUserDto) authentication.getPrincipal();

			// Actualizamos los datos
			codifyUser.setUsername(usuario.getUsuario());
			codifyUser.setFullName(usuario.getNombre() + " " + usuario.getApellidoPaterno() + " " + usuario.getApellidoMaterno());
			codifyUser.setRut(usuario.getRut());

			// Volvemos a generar el objeto
			authentication = new UsernamePasswordAuthenticationToken(codifyUser, usuario.getPass(),
					codifyUser.getAuthorities());

			jwt = generateToken(authentication);

		} catch (UserNotAuthException e) {
			log.error("No es posible refrescar el token del usuario " + e.getMessage());
			throw new UserNotAuthException("No es posible refrescar el token del usuario " + e.getMessage());
		}
		log.info("[refreshToken] :: Fin del metodo ");
		return jwt;
	}

	/**
	 * Setea la authentication en el context y genera el nuevo token
	 * 
	 * @param authentication
	 * @return
	 */
	public String generateToken(Authentication authentication) throws UserNotAuthException {
		String jwt ="";
		try {
			jwt = tokenProvider.generateToken(authentication);
		} catch (IOException e) {
			throw new UserNotAuthException("no se puede generar token");
		}
		return jwt;
	}
	
	
	
}
