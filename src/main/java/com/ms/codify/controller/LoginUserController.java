package com.ms.codify.controller;

import org.springframework.http.ResponseEntity;

import com.ms.codify.dto.LoginRequestDto;
import com.ms.codify.dto.LoginResponseDto;
import com.ms.codify.exception.UserNotAuthException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * LoginUserController - Capa de Rest - Servicio de login - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Api(value = "Microservicio de Login", description = "Esta API tiene los servicios referentes a operaciones de autentificacion")
public interface LoginUserController {


	/**
	 * Metodo encargado de llamar la autentificacion de parque y asignar los roles al token creado.
	 * 
	 * @param dto UserAuthRequestDTO.class 
	 * @return
	 */
	
	/**
	 * autenticacionUsuario - Metodo encargado crear token con los datos de usuarios ademas de roles, permisos y tenant. - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @version jdk-11
	 * @param dto UserAuthRequestDTO.class objeto request de la autentificacion
	 * @return ResponseEntity<UserAuthResponseDTO> see UserAuthResponseDTO objeto respuesta de la autentificacion
	 */
	@ApiOperation(value = "Autentificar", notes = "Retorna los datos de la api de coneccion a nuestra aplicacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
	public ResponseEntity<LoginResponseDto> autenticacionUsuario(LoginRequestDto dto)throws UserNotAuthException ;
	
	
	
}
